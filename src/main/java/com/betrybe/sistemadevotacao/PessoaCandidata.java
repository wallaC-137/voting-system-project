package com.betrybe.sistemadevotacao;


/**
 * The type Pessoa candidata.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;
  private int votos;

  /**
   * Instantiates a new Pessoa candidata.
   *
   * @param nome   the nome
   * @param numero the numero
   */
  public PessoaCandidata(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
    this.votos = 0;
  }

  /**
   * Gets numero.
   *
   * @return the numero
   */
  public int getNumero() {
    return numero;
  }

  /**
   * Sets numero.
   *
   * @param numero the numero
   */
  public void setNumero(int numero) {
    this.numero = numero;
  }

  /**
   * Gets votos.
   *
   * @return the votos
   */
  public int getVotos() {
    return votos;
  }

  /**
   * Sets votos.
   *
   * @param votos the votos
   */
  public void setVotos(int votos) {
    this.votos = votos;
  }

  /**
   * Receber voto.
   */
  public void receberVoto() {
    this.votos++;
  }

  public String getNome() {
    return super.getNome();
  }

  public void setNome(String nome) {
    super.setNome(nome);
  }


}
