import dao.ClienteDAO;

public class Main {

    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();

        System.out.println("=================================");
        System.out.println("     PRUEBA DELETE - CLIENTE");
        System.out.println("=================================");

        int idCliente = 1;

        boolean resultado = clienteDAO.eliminar(idCliente);

        if (resultado) {
            System.out.println("CLIENTE ELIMINADO CORRECTAMENTE.");
        } else {
            System.out.println("NO SE PUDO ELIMINAR EL CLIENTE.");
        }

        System.out.println("=================================");
        System.out.println("     PRUEBA DELETE FINALIZADA");
        System.out.println("=================================");
    }
}