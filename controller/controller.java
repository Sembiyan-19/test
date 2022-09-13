package com.ideas2it.employeeManagement.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import com.ideas2it.employeeManagement.service.EmployeeService;
import com.ideas2it.employeeManagement.service.impl.EmployeeServiceImpl;
import com.ideas2it.employeeManagementException.EmployeeManagementException;

/**
 * Servlet implementation class projectController
 *
 * @version 1.1 21 April 2021
 * @author Sembiyan
 */
public class EmployeeController extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    /**
     *
     * @param request
     *     object that contains the request the client has made of the servlet
     * @param response
     *     object that contains the response the servlet sends to the client
     * @throws ServletException
     *     if an input or output error is detected when the servlet handles
     * the POST request
     * @throws IOException
     *     if the request for the POST could not be handled
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "addEmployee":
                addEmployee(request, response);
                break;
            case "updateEmployee":
                updateEmployee(request, response);
                break;
            case "addAddress":
                addNewAddress(request, response);
                break;
            case "updateAddress":
                updateAddress(request, response);
                break;
            case "showEmployee":
                showEmployee(request, response);
                break;
        }
    }

    /**
     *
     * @param request
     *     object that contains the request the client has made of the servlet
     * @param response
     *     object that contains the response the servlet sends to the client
     * @throws ServletException
     *     if an input or output error is detected when the servlet handles
     * the GET request
     * @throws IOException
     *     if the request for the GET could not be handled
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "showAllEmployees":
                showAllEmployees(request, response);
                break;
            case "createEmployee":
                createNewEmployee(request, response);
                break;
            case "showEmployee":
                showEmployee(request, response);
                break;
            case "deleteEmployee":
                deleteEmployee(request, response);
                break;
            case "editEmployee":
                editEmployee(request, response);
                break;
            case "assignProject":
                assignAProject(request, response);
                break;
            default:
                doGetExtention(action, request, response);
                break;
        }
    }

    /**
     * Extension the switch case in doGet method
     * @action        action chosen by the user
     * @param request
     *     object that contains the request the client has made of the servlet
     * @param response
     *     object that contains the response the servlet sends to the client
     *  @throws ServletException
     *     if an input or output error is detected when the servlet handles
     * the GET request
     * @throws IOException
     *     if the request for the GET could not be handled
     */
    private void doGetExtention(String action, HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        switch (action) {
            case "unassignProject":
                unnassignAProject(request, response);
                break;
            case "showAvailableProjects":
                showAvailableProjects(request, response);
                break;
            case "deleteAddress":
                deleteExistingAddress(request, response);
                break;
            case "editAddress":
                editAddress(request, response);
                break;
            case "createAddress":
                createNewAddress(request, response);
                break;
            case "index":
                goHomePage(request, response);
                break;
            case "viewDeletedEmployees":
                showDeletedEmployees(request, response);
                break;
            case "restoreEmployee":
                restoreEmployee(request, response);
                break;
            default:
                showAllEmployees(request, response);
                break;
        }
    }

    /**
     * Redirects to the index page
     * @param request
     *     object that contains the request the client has made of the servlet
     * @param response
     *     object that contains the response the servlet sends to the client
     */
    private void goHomePage(HttpServletRequest request,
                            HttpServletResponse response) {
        try {
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }