package sv.edu.udb.www.models;

import sv.edu.udb.www.utils.JpaUtil;
import sv.edu.udb.www.entities.CategoriaEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class CategoriaModel {
    public List<CategoriaEntity> listarCategorias() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createQuery("SELECT c FROM CategoriaEntity c");
            List<CategoriaEntity> lista = consulta.getResultList();
            em.close();
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
}