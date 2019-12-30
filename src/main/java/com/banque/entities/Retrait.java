package com.banque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.core.sym.Name;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

}
