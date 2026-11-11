package com.banca.infraestructura.adaptadores;

import com.banca.dominio.entidades.Transaccion;
import com.banca.dominio.repositorios.RepositorioTransaccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdaptadorTransaccionJPA implements RepositorioTransaccion {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Transaccion guardar(Transaccion transaccion) {
        if (transaccion.getId() == null) {
            entityManager.persist(transaccion);
            return transaccion;
        } else {
            return entityManager.merge(transaccion);
        }
    }

    @Override
    public Optional<Transaccion> buscarPorId(String id) {
        Transaccion transaccion = entityManager.find(Transaccion.class, id);
        return Optional.ofNullable(transaccion);
    }

    @Override
    public List<Transaccion> buscarPorCuentaId(String cuentaId) {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t WHERE t.cuentaId = :cuentaId ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        query.setParameter("cuentaId", cuentaId);
        return query.getResultList();
    }

    @Override
    public List<Transaccion> buscarPorCuentaIdYFecha(String cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t WHERE t.cuentaId = :cuentaId " +
            "AND t.fechaTransaccion BETWEEN :fechaInicio AND :fechaFin " +
            "ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        return query.getResultList();
    }

    @Override
    public List<Transaccion> buscarTodos() {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        return query.getResultList();
    }

    @Override
    public void eliminar(String id) {
        Transaccion transaccion = entityManager.find(Transaccion.class, id);
        if (transaccion != null) {
            entityManager.remove(transaccion);
        }
    }

    @Override
    public boolean existePorId(String id) {
        Transaccion transaccion = entityManager.find(Transaccion.class, id);
        return transaccion != null;
    }

    @Override
    public List<Transaccion> buscarPorTipo(String cuentaId, String tipo) {
        TypedQuery<Transaccion> query = entityManager.createQuery(
            "SELECT t FROM Transaccion t WHERE t.cuentaId = :cuentaId AND t.tipo = :tipo " +
            "ORDER BY t.fechaTransaccion DESC",
            Transaccion.class
        );
        query.setParameter("cuentaId", cuentaId);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }
}