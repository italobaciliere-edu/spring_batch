package br.com.bacicorp.MigracaoDadosJob.writer;

import br.com.bacicorp.MigracaoDadosJob.model.Pessoa;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class BancoPessoaWriterConfig {

  public JdbcBatchItemWriter<Pessoa> itemWriter(
      @Qualifier("appDataSource") DataSource dataSource){
    return new JdbcBatchItemWriterBuilder<Pessoa>()
        .dataSource(dataSource)
        .sql("INSERT INTO pessoa(id, nome, email, dataNascimento, idade) VALUES (?, ?, ?, ?, ?)")
        .itemPreparedStatementSetter(itemPreparedStatementSetter())
        .build();
  }

  private ItemPreparedStatementSetter<Pessoa> itemPreparedStatementSetter() {
    return new ItemPreparedStatementSetter<Pessoa>() {
      @Override
      public void setValues(Pessoa pessoa, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, pessoa.getId());
        preparedStatement.setString(2, pessoa.getNome());
        preparedStatement.setString(3, pessoa.getEmail());
        preparedStatement.setDate(4, new Date(pessoa.getDataNascimento().getTime()));
        preparedStatement.setInt(5, pessoa.getIdade());
      }
    };
  }

}
