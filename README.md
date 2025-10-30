# ⚔️ Sistema de Combate RPG Modular (Padrão Strategy)

## Visão Geral do Projeto

Este projeto demonstra a implementação de um sistema de combate robusto e altamente flexível para um motor de RPG, utilizando o **Padrão de Projeto Strategy (Estratégia)** em Java.

O objetivo principal foi desacoplar o comportamento de ataque (a lógica da arma) do objeto que o executa (o Personagem). Isso permite que os personagens alterem completamente seu estilo de combate (e seus efeitos especiais) em tempo de execução, apenas trocando a arma equipada.

## 🎯 Padrão de Projeto Aplicado: Strategy (Estratégia Comportamental)

| Componente | Classes | Função no Padrão |
| :--- | :--- | :--- |
| **Strategy (Interface)** | `Arma` | Define o contrato comum para todos os algoritmos de ataque. |
| **Concrete Strategy** | `EspadaLonga`, `CajadoArcano`, etc. | Implementa a lógica específica (dano, custo de Mana, efeito especial) de cada ataque. |
| **Contexto** | `Personagem` | Mantém a referência à `Arma` e delega a execução do ataque, permitindo a troca dinâmica de estratégias. |

## ✨ Funcionalidades e Arquitetura

### 1. Sistema de Armas e Efeitos (Estratégias)
Cada arma é uma estratégia distinta, encapsulando sua lógica de combate:
* **Gestão de Recursos:** As armas verificam o `Mana` e os atributos (`Força`, `Destreza`, `Inteligência`) do `Personagem` antes de serem utilizadas ou equipadas.
* **Efeitos Únicos:** Implementação de efeitos de status com duração por turno:
    * **`Sangramento`:** Dano por tempo (DoT).
    * **`Queimadura`:** Dano por tempo (DoT).
    * **`Atordoado`:** Pula o turno do alvo.
    * **`Ataque Furtivo` (`AdagaSombria`):** Dano triplo contra alvos já afetados por um status.

### 2. Classes de Personagem (Contexto Estendido)
As classes herdam de `Personagem` para definir características únicas:
* **Atributos:** Força, Destreza e Inteligência fixos.
* **Regras de Classe:** O método `podeUsarTipo()` restringe quais armas (`EspadaLonga`, `ArcoElfico`, etc.) são permitidas para cada classe.
* **Habilidades Passivas:** Inclusão de lógicas específicas de classe, como redução de dano (`Guerreiro`) ou regeneração de Mana (`Mago`).

### 3. Gerenciamento de Batalha
* A classe `Batalha` orquestra o combate, gerencia a sequência de turnos, aplica os danos por status (`StatusEffect`) e verifica a condição de vitória/derrota.

## 🚀 Como Executar

O projeto está configurado com as seguintes classes principais:
1.  **Classes de Modelo:** `Personagem`, `Arma`, `StatusEffect` (e suas implementações).
2.  **Classe de Fluxo:** `Batalha` (gerencia turnos).
3.  **Classe de Teste:** `Main.java` contém a simulação de combate, onde os personagens trocam de armas dinamicamente para demonstrar a flexibilidade do padrão.

Para compilar e executar (usando o terminal padrão Java):

```bash
# Navegue até o diretório onde estão seus arquivos .java
cd RpgCombatSystem/src

# Compile todas as classes
javac *.java armas/*.java efeitos/*.java

# Execute a classe principal (Main)
java Main
