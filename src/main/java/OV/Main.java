package OV;

import OV.DAO.ReizigerDAO;
import OV.DAO.ReizigerDAOPsql;
import OV.Domein.Reiziger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/ovchip";
        String user = "postgres";
        String password = "password";

        Connection conn = DriverManager.getConnection(url, user, password);
        ReizigerDAO reizigerDAO = new ReizigerDAOPsql(conn);

        testReizigerDAO(reizigerDAO);
    }

    /**
     * P2. Reiziger DAO: persistentie van een klasse
     *
     * Deze methode test de CRUD-functionaliteit van de Reiziger DAO
     *
     * @throws SQLException
     */
    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        // Haal alle reizigers op uit de database
        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        // Maak een nieuwe reiziger aan en persisteer deze in de database
        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum).toLocalDate());
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");

        // Test findById
        System.out.println("[Test] ReizigerDAO.findById(77):");
        Reiziger gevonden = rdao.findById(77);
        System.out.println(gevonden);
        System.out.println();

        // Test update
        System.out.println("[Test] ReizigerDAO.update() wijzigt geboortedatum van Sietske naar 1990-01-01:");
        sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf("1990-01-01").toLocalDate());
        rdao.update(sietske);
        System.out.println(rdao.findById(77));
        System.out.println();

        // Test delete
        System.out.println("[Test] ReizigerDAO.delete() verwijdert Sietske:");
        rdao.delete(sietske);
        reizigers = rdao.findAll();
        System.out.println("Aantal reizigers na delete: " + reizigers.size());
    }
}
