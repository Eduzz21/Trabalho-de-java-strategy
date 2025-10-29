public class Main {
    public static void main(String[] args) {
        // Criação dos Personagens
        Guerreiro g1 = new Guerreiro();
        Mago m1 = new Mago();
        Arqueiro a1 = new Arqueiro();
        
        System.out.println("\n--- TESTE DE EQUIPAMENTO ---");
        
        // Teste de Requisitos: Guerreiro não pode usar Arco (Destreza baixa)
        g1.equiparArma(new ArcoElfico()); 
        // Guerreiro equipa sua estratégia principal
        g1.equiparArma(new EspadaLonga()); 
        
        // Mago equipa sua estratégia
        m1.equiparArma(new CajadoArcano()); 
        
        // Arqueiro: Híbrido implícito, podendo alternar entre duas estratégias de classes diferentes
        a1.equiparArma(new ArcoElfico()); // Estratégia de alcance
        a1.equiparArma(new AdagaSombria()); // Estratégia furtiva (troca de estratégia)

        
        // --- INÍCIO DA BATALHA ---
        
        Batalha batalha = new Batalha(g1, m1);
        
        // Turno 1: Guerreiro ataca e aplica Sangramento. Mago ataca e aplica Queimadura.
        batalha.proximoTurno(); 
        
        // Mago troca de estratégia para um ataque furtivo que aproveita o Status
        m1.equiparArma(new AdagaSombria());
        
        // Turno 2: Efeitos aplicam dano. Mago usa Adaga Furtiva (dano triplo devido à Queimadura).
        batalha.proximoTurno();
        
        // Guerreiro troca de estratégia para tentar Atordoar
        g1.equiparArma(new MachadodeGuerra());
        
        // Turno 3: Guerreiro tenta Atordoar. Efeitos terminam/continuam.
        batalha.proximoTurno(); 

        // Continua até que um seja derrotado
        batalha.proximoTurno();
        batalha.proximoTurno();
    }
}