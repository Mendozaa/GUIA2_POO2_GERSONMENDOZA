/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.PersonaCtrl;
import com.sv.udb.controlador.TipoPersonaCtrl;
import com.sv.udb.controlador.UbicacionCtrl;
import com.sv.udb.modelo.Persona;
import com.sv.udb.modelo.TipoPersona;
import com.sv.udb.modelo.Ubicacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laboratorio
 */
@WebServlet(name = "PersServ", urlPatterns = {"/PersServ"})
public class PersServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean esValido = request.getMethod().equals("POST");
        if(esValido){
            String mens="";
            String CRUD = request.getParameter("btnPers");
            
            if(CRUD.equals("Agregar")){
                Ubicacion obje = new UbicacionCtrl().cons(Integer.parseInt(request.getParameter("CodiUbicGeog")));
                TipoPersona obje1 = new TipoPersonaCtrl().cons(Integer.parseInt(request.getParameter("CodiTipoPers")));
                Persona objeEqui = new Persona();
                objeEqui.setCodiUbicPers(obje);
                objeEqui.setCodiTipoPers(obje1);
                objeEqui.setCodiPers(Integer.parseInt(request.getParameter("CodiPers")));
                objeEqui.setNombPers(request.getParameter("NombPers"));
                objeEqui.setApelPers(request.getParameter("ApelPers"));
                objeEqui.setGenePers(request.getParameter("GenePers"));
                objeEqui.setFechNaciPers(request.getParameter("FechNaciPers"));
                objeEqui.setDuiPers(request.getParameter("DuiPers"));
                objeEqui.setNitPers(request.getParameter("NitPers"));
                objeEqui.setTipoSangPers(request.getParameter("TipoSangPers"));
                objeEqui.setFechAlta(request.getParameter("FechAlta"));
                objeEqui.setFechBaja(request.getParameter("FechBaja"));
                objeEqui.setEstaPers(Integer.parseInt(request.getParameter("EstaPers")));
                mens = new PersonaCtrl().guar(objeEqui) ? "Datos guardados" : request.getParameter("CodiPers");
            }
            else if(CRUD.equals("Consultar")){
               int codiPers= Integer.parseInt(request.getParameter("CodiPersRadio") == null ? "0" : request.getParameter("CodiPersRadio"));
               Persona objeEqui = new PersonaCtrl().cons(codiPers);
               if(objeEqui != null){
               request.setAttribute("CodiPers", objeEqui.getCodiPers());
               request.setAttribute("CodiTipoPers", objeEqui.getCodiTipoPers());
               request.setAttribute("CodiUbicPers", objeEqui.getCodiUbicPers());
               request.setAttribute("NombPers", objeEqui.getNombPers());
               request.setAttribute("ApelPers", objeEqui.getApelPers());
               request.setAttribute("GenePers", objeEqui.getGenePers());
               request.setAttribute("FechNaciPers", objeEqui.getFechNaciPers());
               request.setAttribute("DuiPers", objeEqui.getDuiPers());
               request.setAttribute("NitPers", objeEqui.getNitPers());
               request.setAttribute("FechAlta", objeEqui.getFechAlta());
               request.setAttribute("FechBaja", objeEqui.getFechBaja());
               request.setAttribute("NombPers", objeEqui.getNombPers());
               }
            }
            else if(CRUD.equals("Modificar")){
                Ubicacion obje = new UbicacionCtrl().cons(Integer.parseInt(request.getParameter("CodiUbicGeog")));
                TipoPersona obje1 = new TipoPersonaCtrl().cons(Integer.parseInt(request.getParameter("CodiTipoPers")));
                Persona objeEqui = new Persona();
                objeEqui.setCodiUbicPers(obje);
                objeEqui.setCodiTipoPers(obje1);
                objeEqui.setCodiPers(Integer.parseInt(request.getParameter("CodiPers")));
                objeEqui.setNombPers(request.getParameter("NombPers"));
                objeEqui.setApelPers(request.getParameter("ApelPers"));
                objeEqui.setGenePers(request.getParameter("GenePers"));
                objeEqui.setFechNaciPers(request.getParameter("FechNaciPers"));
                objeEqui.setDuiPers(request.getParameter("DuiPers"));
                objeEqui.setNitPers(request.getParameter("NitPers"));
                objeEqui.setTipoSangPers(request.getParameter("TipoSangPers"));
                mens = new PersonaCtrl().modi(objeEqui) ? "Datos modificados" : "Datos no modificados";
            }
            else if(CRUD.equals("Eliminar")){
                Persona objeEqui = new Persona();
                objeEqui.setCodiPers(Integer.parseInt(request.getParameter("CodiPers")));
                mens = new PersonaCtrl().elim(objeEqui) ? "Datos eliminados" : "Datos no eliminados";
            }
        request.setAttribute("mensAler", mens);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
        /*request.setAttribute("mensAler", "Este es un mensaje");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
