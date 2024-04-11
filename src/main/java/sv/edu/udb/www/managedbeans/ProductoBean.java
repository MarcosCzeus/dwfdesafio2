package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.entities.ProductoEntity;
import sv.edu.udb.www.models.productosModel;
import sv.edu.udb.www.entities.CategoriaEntity;
import sv.edu.udb.www.models.CategoriaModel;
import sv.edu.udb.www.utils.JsfUtil;

import java.util.List;

@ManagedBean
@RequestScoped
public class ProductoBean {
    productosModel modelo = new productosModel();
    private ProductoEntity producto;
    private List<ProductoEntity> listaProductos;
    private CategoriaModel categoriaModel = new CategoriaModel();
    private List<CategoriaEntity> listaCategorias;

    public ProductoBean() {
        producto = new ProductoEntity();
    }

    public ProductoEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductoEntity producto) {
        this.producto = producto;
    }

    public List<ProductoEntity> getListaProductos() {
        return modelo.listarProductos();
    }

    public List<CategoriaEntity> getListaCategorias() {
        listaCategorias = categoriaModel.listarCategorias();
        return listaCategorias;
    }

    public String guardarProducto() {
        if (modelo.insertarProducto(producto) != 1) {
            JsfUtil.setErrorMessage(null, "Ya se registró un producto con este ID");
            return null;
        } else {
            JsfUtil.setFlashMessage("exito", "Producto registrado exitosamente");
            return "registroProductos?faces-redirect=true";
        }
    }

    public String modificarProducto() {
        if (modelo.modificarProducto(producto) != 1) {
            JsfUtil.setErrorMessage(null, "No se puede modificar el producto");
            return null;
        } else {
            JsfUtil.setFlashMessage("exito", "Producto modificado exitosamente");
            return "registroProductos?faces-redirect=true";
        }
    }

    public String eliminarProducto() {
        int id = Integer.parseInt(JsfUtil.getRequest().getParameter("id"));

        if (modelo.eliminarProducto(id) > 0) {
            JsfUtil.setFlashMessage("exito", "Producto eliminado exitosamente");
        } else {
            JsfUtil.setErrorMessage(null, "No se pudo borrar este producto");
        }
        return "registroProductos?faces-redirect=true";
    }
}
