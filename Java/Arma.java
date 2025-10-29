public interface Arma {
    String getNome();
    int getDanoBase();
    int getCustoMana();
    
    // O método de ataque, onde a estratégia é executada
    void atacar(Personagem atacante, Personagem alvo);
    
    // Método para verificar se o personagem atende aos requisitos (atributos + classe)
    boolean podeUsar(Personagem atacante);
}