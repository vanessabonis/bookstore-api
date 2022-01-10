package bookstoreapi.config;

import bookstoreapi.entities.Categoria;
import bookstoreapi.entities.Livro;
import bookstoreapi.repositories.CategoriaRepository;
import bookstoreapi.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {
        //povoando banco de dados

        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);

        cat1.getLivros().add(l1);

        //salvando no banco
        categoriaRepository.saveAll(Arrays.asList(cat1));
        livroRepository.saveAll(Arrays.asList(l1));

    }


}
