/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author gersonfrancisco
 */
public class TipoPersona {
    private int CodiTipoPers;
    private String NombTipoPers;

    public TipoPersona() {
    }

    public TipoPersona(int CodiTipoPers, String NombTipoPers) {
        this.CodiTipoPers = CodiTipoPers;
        this.NombTipoPers = NombTipoPers;
    }

    public int getCodiTipoPers() {
        return CodiTipoPers;
    }

    public void setCodiTipoPers(int CodiTipoPers) {
        this.CodiTipoPers = CodiTipoPers;
    }

    public String getNombTipoPers() {
        return NombTipoPers;
    }

    public void setNombTipoPers(String NombTipoPers) {
        this.NombTipoPers = NombTipoPers;
    }

    @Override
    public String toString() {
        return NombTipoPers;
    }
    
    
}
