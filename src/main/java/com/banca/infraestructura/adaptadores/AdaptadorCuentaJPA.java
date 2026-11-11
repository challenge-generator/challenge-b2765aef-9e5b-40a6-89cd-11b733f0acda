package com.banca.infraestructura.adaptadores;

import com.banca.dominio.entidades.Cuenta;
import com.banca.dominio.repositorios.RepositorioCuenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdaptadorCuentaJPA implements RepositorioCuenta {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cuenta guardar(Cuenta cuenta) {
        if (cuenta.getId() == null) {
            entityManager.persist(cuenta);
            return cuenta;
        } else {
            return entityManager.merge(cuenta);
        }
    }

    @Override
    public Optional<Cuenta> buscarPorId(String id) {
        Cuenta cuenta = entityManager.find(Cuenta.class, id);
        return Optional.ofNullable(cuenta);
    }

    @Override
    public Optional<Cuenta> buscarPorNumero(String numeroCuenta) {
        TypedQuery<Cuenta> query = entityManager.createQuery(
            "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta",
            Cuenta.class
        );
        query.setParameter("numeroCuenta", numeroCuenta);
        List<Cuenta> resultados = query.getResultList();
        return resultados.isEmpty() ? Optional.empty() : Optional.of(resultados.get(0));
    }

    @Override
    public List<Cuenta> buscarPorClienteId(String clienteId) {
        TypedQuery<Cuenta> query = entityManager.createQuery(
            "SELECT c FROM Cuenta c WHERE c.clienteId = :clienteId",
            Cuenta.class
        );
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    @Override
    public List<Cuenta> buscarTodos() {
        TypedQuery<Cuenta> query = entityManager.createQuery(
            "SELECT c FROM Cuenta c",
            Cuenta.class
        );
        return query.getResultList();
    }

    @Override
    public void eliminar(String id) {
        Cuenta cuenta = entityManager.find(Cuenta.class, id);
        if (cuenta != null) {
            entityManager.remove(cuenta);
        }
    }

    @Override
    public boolean existePorId(String id) {
        Cuenta cuenta = entityManager.find(Cuenta.class, id);
        return cuenta != null;
    }

    @Override
    public boolean tieneSaldoSuficiente(String cuentaId, BigDecimal monto) {
        Optional<Cuenta> cuentaOpt = buscarPorId(cuentaId);
        if (cuentaOpt.isEmpty()) {
            return false;
        }
        Cuenta cuenta = cuentaOpt.get();
        return cuenta.getSaldo().compareTo(monto) >= 0;
    }

    @Override
    public void actualizarSaldo(String cuentaId, BigDecimal nuevoSaldo) {
        Cuenta cuenta = entityManager.find(Cuenta.class, cuentaId);
        if (cuenta != null) {
            cuenta.setSaldo(nuevoSaldo);
            entityManager.merge(cuenta);
        }
    }
}