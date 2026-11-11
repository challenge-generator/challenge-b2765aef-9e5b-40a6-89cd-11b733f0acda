package com.banca.infraestructura.adaptadores;

import com.banca.dominio.entidades.Cliente;
import com.banca.dominio.repositorios.RepositorioCliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class AdaptadorClienteJPA implements RepositorioCliente {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cliente guardar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId(UUID.randomUUID().toString());
            entityManager.persist(cliente);
            return cliente;
        } else {
            return entityManager.merge(cliente);
        }
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return Optional.ofNullable(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorDocumento(String numeroDocumento) {
        TypedQuery<Cliente> query = entityManager.createQuery(
            "SELECT c FROM Cliente c WHERE c.numeroDocumento = :numeroDocumento",
            Cliente.class
        );
        query.setParameter("numeroDocumento", numeroDocumento);
        List<Cliente> resultados = query.getResultList();
        return resultados.isEmpty() ? Optional.empty() : Optional.of(resultados.get(0));
    }

    @Override
    public List<Cliente> buscarTodos() {
        TypedQuery<Cliente> query = entityManager.createQuery(
            "SELECT c FROM Cliente c",
            Cliente.class
        );
        return query.getResultList();
    }

    @Override
    public void eliminar(String id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        if (cliente != null) {
            entityManager.remove(cliente);
        }
    }

    @Override
    public boolean existePorId(String id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        return cliente != null;
    }
}