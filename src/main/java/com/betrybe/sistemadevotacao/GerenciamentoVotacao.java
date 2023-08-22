package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfsComputados = new ArrayList<>();

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    try {
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        if (Objects.equals(pessoaCandidata.getNumero(), numero)) {
          throw new RuntimeException("Número da pessoa candidata já utilizado!");
        }
      }
      pessoasCandidatas.add(new PessoaCandidata(nome, numero));

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    try {
      for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
        if (Objects.equals(pessoaEleitora.getCpf(), cpf)) {
          throw new RuntimeException("Pessoa eleitora já cadastrada!");
        }
      }
      pessoasEleitoras.add(new PessoaEleitora(nome, cpf));

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    try {
      for (String cpfComputado : cpfsComputados) {
        if (Objects.equals(cpfComputado, cpfPessoaEleitora)) {
          throw new RuntimeException("Pessoa eleitora já votou!");
        }
      }

      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        if (Objects.equals(pessoaCandidata.getNumero(), numeroPessoaCandidata)) {
          pessoaCandidata.receberVoto();
          cpfsComputados.add(cpfPessoaEleitora);

          return;
        }
      }
      throw new RuntimeException("Número da pessoa candidata não encontrado!");

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void mostrarResultado() {
    try {
      if (cpfsComputados.isEmpty()) {
        throw new RuntimeException("É preciso ter pelo menos um voto para mostrar o resultado.");
      }

      int totalDeVotosComputados = cpfsComputados.size();

      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        int votosDaPessoa = pessoaCandidata.getVotos();
        int porcentagem = (votosDaPessoa * 100) / totalDeVotosComputados;

        System.out.println(
            "Nome: " + pessoaCandidata.getNome()
                + " - " + votosDaPessoa + " votos"
                + " ( " + porcentagem + "% )");
      }

      System.out.println("Total de votos: " + totalDeVotosComputados);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
