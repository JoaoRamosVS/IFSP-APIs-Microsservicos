package br.ifsp.contacts.repository;

import br.ifsp.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Esta interface extende JpaRepository, que nos fornece métodos prontos
 * para acessar e manipular dados no banco de dados. Basta especificar
 * a classe de entidade (Contact) e o tipo da chave primária (Long).
 */
    public interface ContactRepository extends JpaRepository<Contact, Long> {
        List<Contact> findByNomeContainingIgnoreCase(String nome);
    }
