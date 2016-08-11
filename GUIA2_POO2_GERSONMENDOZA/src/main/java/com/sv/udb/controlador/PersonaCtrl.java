/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Persona;
import com.sv.udb.modelo.TipoPersona;
import com.sv.udb.modelo.Ubicacion;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleso
 */
public class PersonaCtrl {
    
    public Persona cons( int codiPers){
      Persona resp = null;
      Connection cn = new Conexion().getConn();
      try{
          String Consulta="select a.codi_pers, a.nomb_pers, a.apel_pers, a.foto_pers, b.NOMB_TIPO_PERS, a.gene_pers, a.fech_naci_pers, \n" +
"a.dui_pers, a.nit_pers, a.tipo_sang_pers, c.NOMB_UBIC_GEOG, a.fech_alta, a.fech_baja, a.esta from pers a, tipo_pers b, ubic_geog c \n" +
"where a.CODI_TIPO_PERS=b.CODI_TIPO_PERS and a.CODI_UBIC_GEOG=C.CODI_UBIC_GEOG and a.codi_pers=?";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           cmd.setInt(1, codiPers);
           ResultSet rs = cmd.executeQuery();
           if(rs.next()){
               resp= new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), new TipoPersona(rs.getInt(1), rs.getString(2)),  rs.getString(6),
               rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), new Ubicacion(rs.getInt(1), rs.getString(2)), rs.getString(12), rs.getString(13),
               rs.getInt(14));
           }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;  
    }
    
    public List<Persona> consTodo(){
      List <Persona> resp = new ArrayList<>();
     
      Connection cn = new Conexion().getConn();
      try{
           String Consulta="select a.codi_pers, a.nomb_pers, a.apel_pers, a.foto_pers, b.NOMB_TIPO_PERS, a.gene_pers, a.fech_naci_pers, \n" +
"a.dui_pers, a.nit_pers, a.tipo_sang_pers, c.NOMB_UBIC_GEOG, a.fech_alta, a.fech_baja, a.esta from pers a, tipo_pers b, ubic_geog c \n" +
"where a.CODI_TIPO_PERS=b.CODI_TIPO_PERS and a.CODI_UBIC_GEOG=C.CODI_UBIC_GEOG;";
           PreparedStatement cmd = cn.prepareStatement(Consulta);
           ResultSet rs = cmd.executeQuery();
           while(rs.next()){
               resp.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), new TipoPersona(rs.getInt(1), rs.getString(2)),  rs.getString(6),
               rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), new Ubicacion(rs.getInt(1), rs.getString(2)), rs.getString(12), rs.getString(13),
               rs.getInt(14)));
           }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;  
    }
    
    public boolean guar(Persona obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "INSERT INTO PERS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiPers());
            cmd.setString(2, obje.getNombPers());
            cmd.setString(3, obje.getApelPers());
            cmd.setString(4, obje.getFotoPers());
            cmd.setInt(5, obje.getCodiTipoPers().getCodiTipoPers());
            cmd.setString(6, obje.getGenePers());
            cmd.setString(7, obje.getFechNaciPers());
            cmd.setString(8, obje.getDuiPers());
            cmd.setString(9, obje.getNitPers());
            cmd.setString(10, obje.getTipoSangPers());
            cmd.setInt(11, obje.getCodiUbicPers().getCodiUbic());
            cmd.setString(12, obje.getFechAlta());
            cmd.setString(13, obje.getFechBaja());
            cmd.setInt(14, obje.getEstaPers());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public boolean modi(Persona obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "UPDATE pers SET nomb_pers=?, apel_pers=?, foto_pers=?, codi_tipo_pers=?, gene_pers=?,"
                   + "fech_naci_pers=?, dui_pers=?, nit_pers=?, tipo_sang_pers=?, codi_ubic_geog=?,"
                   + " fech_alta=?, fech_baja=? WHERE codi_pers=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setString(1, obje.getNombPers());
            cmd.setString(2, obje.getApelPers());
            cmd.setString(3, obje.getFotoPers());
            cmd.setInt(4, obje.getCodiTipoPers().getCodiTipoPers());
            cmd.setString(5, obje.getGenePers());
            cmd.setString(6, obje.getFechNaciPers());
            cmd.setString(7, obje.getDuiPers());
            cmd.setString(8, obje.getNitPers());
            cmd.setString(9, obje.getTipoSangPers());
            cmd.setInt(10, obje.getCodiUbicPers().getCodiUbic());
            cmd.setString(11, obje.getFechAlta());
            cmd.setString(12, obje.getFechBaja());
            cmd.setInt(13, obje.getEstaPers());
            cmd.setInt(14, obje.getCodiPers());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
    
    public boolean elim(Persona obje){
        boolean resp=false;
        Connection cn = new Conexion().getConn();
        try{
            String Consulta = "DELETE FROM pers WHERE codi_pers=?";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            cmd.setInt(1, obje.getCodiPers());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(cn!=null){
                try{
                if(!cn.isClosed()){
                    cn.close();
                }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }

}
