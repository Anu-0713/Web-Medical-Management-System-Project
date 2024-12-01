import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "view";

        try {
            switch (action) {
                case "add":
                    showAddForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deletePatient(request, response);
                    break;
                default:
                    listPatients(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "add":
                    addPatient(request, response);
                    break;
                case "edit":
                    updatePatient(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listPatients(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM patients";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Patient> patients = new ArrayList<>();
        while (rs.next()) {
            patients.add(new Patient(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("medical_condition")));
        }

        request.setAttribute("patientList", patients);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewPatients.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addPatient.jsp");
        dispatcher.forward(request, response);
    }

    private void addPatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String medicalCondition = request.getParameter("medicalCondition");

        Connection conn = DatabaseConnection.getConnection();
        String sql = "INSERT INTO patients (name, age, medical_condition) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, medicalCondition);
        stmt.executeUpdate();

        response.sendRedirect("main?action=view");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM patients WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Patient patient = new Patient(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("medical_condition"));
            request.setAttribute("patient", patient);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updatePatient.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String medicalCondition = request.getParameter("medicalCondition");

        Connection conn = DatabaseConnection.getConnection();
        String sql = "UPDATE patients SET name=?, age=?, medical_condition=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, medicalCondition);
        stmt.setInt(4, id);
        stmt.executeUpdate();

        response.sendRedirect("main?action=view");
    }

    private void deletePatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = DatabaseConnection.getConnection();
        String sql = "DELETE FROM patients WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        response.sendRedirect("main?action=view");
    }
}
