package com.customuserdetailsservice.demo.repository;

import com.customuserdetailsservice.demo.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
