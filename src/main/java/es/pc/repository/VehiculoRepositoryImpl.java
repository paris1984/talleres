package es.pc.repository;

import es.pc.entity.VehiculoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
@Slf4j
public class VehiculoRepositoryImpl implements VehiculoRepository {

    private Connection conn;

    @Override
    public void save(VehiculoEntity entity) {

        try {
            PreparedStatement pstmt = conn.prepareStatement(SqlConstants.INSERT_VEHICULO);
            pstmt.setString(1, entity.getMatricula());
            pstmt.setString(2, entity.getTipo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public VehiculoEntity getVehiculo(String matricula) {

        try {
             PreparedStatement pstmt  = conn.prepareStatement(SqlConstants.SELECT_VEHICULO);
             pstmt.setString(1, matricula);
             ResultSet rs    = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getString("matricula") + "\t" +
                        rs.getDouble("tipo"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
