package sv.edu.udb.www.models;

import sv.edu.udb.www.utils.JpaUtil;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.entities.ProductoEntity;
public class productosModel {

        public List<ProductoEntity> listarProductos() {
            EntityManager em = JpaUtil.getEntityManager();
            try {
                Query consulta = em.createQuery("Select p from ProductoEntity p", ProductoEntity.class);
                List<ProductoEntity> lista = consulta.getResultList();
                em.close();
                return lista;
            } catch (Exception e) {
                em.close();
                return null;
            }
        }

        public int insertarProducto(ProductoEntity producto) {
            EntityManager em = JpaUtil.getEntityManager();
            EntityTransaction tran = em.getTransaction();
            try {
                tran.begin();
                em.persist(producto);
                tran.commit();
                em.close();
                return 1;
            } catch (Exception e) {
                em.close();
                return 0;
            }
        }

        public int modificarProducto(ProductoEntity producto) {
            EntityManager em = JpaUtil.getEntityManager();
            EntityTransaction tran = em.getTransaction();
            try {
                tran.begin();
                em.merge(producto);
                tran.commit();
                em.close();
                return 1;
            } catch (Exception e) {
                em.close();
                return 0;
            }
        }

        public int eliminarProducto(Integer idProducto) {
            EntityManager em = JpaUtil.getEntityManager();
            int filasBorradas = 0;
            try {
                ProductoEntity producto = em.find(ProductoEntity.class, idProducto);
                if (producto != null) {
                    EntityTransaction tran = em.getTransaction();
                    tran.begin();
                    em.remove(producto);
                    tran.commit();
                    filasBorradas = 1;
                }
                em.close();
                return filasBorradas;
            } catch (Exception e) {
                em.close();
                return 0;
            }
        }
    }