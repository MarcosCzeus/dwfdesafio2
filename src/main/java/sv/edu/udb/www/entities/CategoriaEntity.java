package sv.edu.udb.www.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "categoria", schema = "productos")
@NamedQueries({
        @NamedQuery(name = "CategoriaEntity.findAll", query = "SELECT e FROM CategoriaEntity e"),
        @NamedQuery(name = "CategoriaEntity.findBynombre", query = "SELECT e from CategoriaEntity e WHERE e.nombre = :nombre")

})
public class CategoriaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoria_id", nullable = false)
    private int categoriaId;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriaEntity that = (CategoriaEntity) o;

        if (categoriaId != that.categoriaId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoriaId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
