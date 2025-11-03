// java
// Caminho: `src/main/java/poo/SistemaPedidos.java`
package poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SistemaPedidos {
    public static void main(String[] args) {
        SpringApplication.run(SistemaPedidos.class, args);
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/produtos")
    public List<Produto> produtos(){
        List<Produto> produtos = new ArrayList<>();

        InputStream is = getClass().getResourceAsStream("/poo/produtos.csv");
        if (is == null) {
            System.out.println("Arquivo não encontrado no classpath: /poo/produtos.csv");
            return produtos;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String linha = br.readLine(); // lê header (ou primeira linha)
            while ((linha = br.readLine()) != null) {
                String[] colunas = linha.split(",", -1);
                if (colunas.length < 5) {
                    System.out.println("Linha ignorada (colunas insuficientes): " + linha);
                    continue;
                }
                try {
                    String id = colunas[0].trim();
                    String nome = colunas[1].trim();
                    double preco = Double.parseDouble(colunas[2].trim());
                    String descricao = colunas[3].trim();
                    int estoque = Integer.parseInt(colunas[4].trim());

                    Produto p = new Produto(id, nome, preco, descricao, estoque);
                    produtos.add(p);
                } catch (NumberFormatException ex) {
                    System.out.println("Erro ao parsear linha, ignorando: " + linha + " -> " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return produtos;
    }
}
