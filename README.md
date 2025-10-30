# ⚔️ Sistema de Combate Dinâmico com Estratégias Trocáveis

## 💡 Padrão de Projeto: Strategy (Estratégia Comportamental)

Este projeto é uma simulação de combate de RPG desenvolvida em Java, focada em demonstrar a eficácia do **Padrão de Projeto Strategy**.

O princípio central é o **desacoplamento** do comportamento de ataque. O `Personagem` (Contexto) delega a ação de combate à `Arma` (Strategy), permitindo a troca completa do estilo de luta em tempo de execução sem modificar a classe principal do herói.

## ✨ Funcionalidades do Sistema

A arquitetura lida com todas as complexidades de um motor de combate de forma modular e organizada:

### 1. Dano e Recursos (Estratégia Única)
Cada `Arma` (Concrete Strategy) possui sua própria lógica encapsulada:
* **Dano Variável:** Cada arma possui um dano base e um cálculo específico.
* **Custo de Mana:** Verificação e consumo do recurso `Mana` a cada ataque.
* **Requisitos de Atributos:** O sistema verifica atributos como **Força**, **Destreza** e **Inteligência** para validar se o personagem pode utilizar a arma.

### 2. Efeitos por Turno (`StatusEffect`)
O sistema gerencia o ciclo de vida de penalidades de combate:
* **Aplicação e Remoção Automática:** Gerenciamento da aplicação e remoção de penalidades por status a cada rodada, controlado pela classe `Batalha`.
* **Status Implementados:** Sangramento, Queimadura e Atordoamento.

### 3. Flexibilidade de Classe (Troca de Comportamento)
* O design permite que personagens alternem instantaneamente entre diferentes tipos de ataque e estratégias.
* Demonstração da criação de personagens "híbridos" que alternam entre estratégias de ataque físico e mágico, como o `Arqueiro` que usa tanto o `Arco Elfico` quanto a `Adaga Sombria`.

## ⚙️ Como Executar

O projeto é escrito em Java. Para rodar a simulação de combate (que está na classe `Main`):

```bash
# Navegue até o diretório dos arquivos .java (Ex: RpgCombatSystem/src)
cd [DIRETORIO_DO_PROJETO]/src

# Compile todas as classes
javac *.java armas/*.java efeitos/*.java

# Execute a classe principal
java Main
