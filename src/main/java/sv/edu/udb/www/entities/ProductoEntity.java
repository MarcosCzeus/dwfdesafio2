package sv.edu.udb.www.entities;
import jakarta.persistence.*;
import sv.edu.udb.www.entities.CategoriaEntity;
@Entity
@Table(name = "producto", schema = "productos")

@NamedQueries({
        @NamedQuery(name = "ProductoEntity.findAll", query = "SELECT e FROM ProductoEntity e"),
@NamedQuery(name = "ProductoEntity.findByproducto_id", query = "SELECT e from ProductoEntity e WHERE e.productoId = :producto"),
        @NamedQuery(name = "ProductoEntity.findBynombre", query = "SELECT e from ProductoEntity e WHERE e.nombre = :nombre"),
        @NamedQuery(name = "ProductoEntity.findBydescrpcion", query = "SELECT e from ProductoEntity e WHERE e.descripcion = :descripcion"),
        @NamedQuery(name = "ProductoEntity.findByprecio", query = "SELECT e from ProductoEntity e WHERE e.precio = :precio"),
        @NamedQuery(name = "ProductoEntity.findBycategoria_id", query = "SELECT e from ProductoEntity e WHERE e.categoriaId = :categoria"),

})
public class ProductoEntity {
    @Id
    @Column(name = "producto_id", nullable = false)
    private int productoId;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = true, length = -1)
    private String descripcion;
    @Basic
    @Column(name = "precio", nullable = false, precision = 2)
    private double precio;
    @OneToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private CategoriaEntity categoriaId;

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriaEntity getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaEntity categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity that = (ProductoEntity) o;

        if (productoId != that.productoId) return false;
        if (Double.compare(that.precio, precio) != 0) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (categoriaId != null ? !categoriaId.equals(that.categoriaId) : that.categoriaId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productoId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (categoriaId != null ? categoriaId.hashCode() : 0);
        return result;
    }
}
