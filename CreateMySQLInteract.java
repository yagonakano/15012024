import java.sql.*;
import java.util.Scanner;

public class CreateMySQLInteract {
    public static void main(String[] args){
        String status = "Nada aconteceu ainda";
        boolean sair = false;
        String str1 = "CREATE TABLE `mysql_connector`.`";
        String str2 = "` (`id` INT NOT NULL AUTO_INCREMENT,`";
        String str3 = "` (`id` INT NOT NULL AUTO_INCREMENT,`";
        Scanner scnInput = new Scanner(System.in);
        String strCreateTable;
        String strNomeTabela;
        String strNomeCampo;
        Connection conn = App.conectar();
        Statement stmSql = null;
        String respSair;
        

        while (sair == false){
        
        try{
            System.out.println("Digite o nome da tabela");
            strNomeTabela = scnInput.nextLine();

            System.out.println("Digite o nome do campo");
            strNomeCampo = scnInput.nextLine();

            strCreateTable = str1 + strNomeTabela + str2 + strNomeCampo + str3;

            stmSql = conn.createStatement();
            stmSql.addBatch(strCreateTable);
            stmSql.executeBatch();
            stmSql.close();
            status = "Ok! Tabela criada com sucesso";

            System.out.println("Deseja criar outra tabela? Digite 'sim' ou 'nao'.");
            respSair = scnInput.nextLine();
            if(respSair.equals("s") || respSair.equals("S")){
                sair = true;
            }
        }    
        catch (Exception e ){
            System.err.println("Ops! Ocorreu um erro" + e);

        }
        System.out.println(status);
    }
    }
}
