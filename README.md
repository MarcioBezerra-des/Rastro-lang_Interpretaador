# Rastro Lang - Interpretador

![Java](https://img.shields.io/badge/Java-8+-orange.svg)

## 📝 Visão Geral

**Rastro Lang** é uma linguagem de programação educacional baseada em comandos para controlar um robô virtual que desenha rastros em uma grade 2D. O projeto implementa um interpretador completo com análise léxica, sintática e execução de comandos.

O robô se move em uma grade 50x50 e pode deixar rastros marcados com `*` quando a caneta está abaixada. Ideal para ensino de conceitos de compiladores e interpretadores.

## ✨ Funcionalidades

* **Movimentação**: 4 direções (FRENTE, CIMA, DIREITA, ESQUERDA)
* **Controle de Caneta**: Liga/desliga o desenho do rastro (CIMA, BAIXO)
* **Repetição**: Estruturas de loop com blocos (`REPETIR N { ... }`)
* **Comentários**: Suporte a comentários de linha com `//`
* **Grid Visual**: Visualização ASCII 50x50 do trajeto do robô

## 🛠️ Stack Técnica e Arquitetura

### Linguagem
* **Java 8+** (compatível até Java 17+)

### Arquitetura do Interpretador
O projeto segue um design clássico de interpretador:
1.  **Análise Léxica** (Scanner/Lexer)
2.  **Análise Sintática** (Parser Descendente Recursivo)
3.  **AST** (Abstract Syntax Tree)
4.  **Interpretador** (Tree-Walking Interpreter)

### Componentes Principais
| Componente | Descrição |
|---|---|
| `TipoToken.java` | Enum com todos os tokens da linguagem |
| `Token.java` | Representação de token (tipo, lexema, literal) |
| `AnalisadorLexico.java` | Tokenizador que converte código fonte em tokens |
| `AnalisadorSintatico.java` | Parser que gera a AST |
| `Comando.java` | Interface para nós da AST |
| `ComandoMover.java` | Nó AST para comando MOVER |
| `ComandoCaneta.java` | Nó AST para comando CANETA |
| `ComandoRepetir.java` | Nó AST para comando REPETIR |
| `Robo.java` | Estado do robô (posição x,y e caneta) |
| `Grid.java` | Grade 50x50 para renderização |
| `Interpretador.java` | Executor da AST |
| `Compilador.java` | Ponto de entrada (main) |

## 📂 Estrutura do Repositório
~~~
Rastro-lang_Interpretaador/ ├── projeto/ # Código fonte do interpretador │ ├── src/ # Arquivos fonte Java │ ├── bin/ # Arquivos compilados │ ├── lib/ # Dependências │ ├── .vscode/ # Configurações VS Code │ └── *.rastro # Exemplos de programas ├── doc/ # Documentação do projeto └── README.md # Este arquivo
~~~
## 📖 Como Funciona

### 1. Análise Léxica
O `AnalisadorLexico` lê o código fonte caractere por caractere e gera uma lista de tokens:
* Identifica palavras-chave (CANETA, MOVER, REPETIR, etc.)
* Reconhece números inteiros
* Identifica símbolos (`{`, `}`)
* Ignora comentários (`//`) e espaços em branco

### 2. Análise Sintática
O `AnalisadorSintatico` usa os tokens para construir uma AST (Árvore de Sintaxe Abstrata) seguindo a gramática:
~~~
programa → comando* comando → cmd_mover | cmd_caneta | cmd_repetir cmd_mover → 'MOVER' direcao 'NUMERO' cmd_caneta → 'CANETA' ('CIMA' | 'BAIXO') cmd_repetir → 'REPETIR' 'NUMERO' '{' programa '}' direcao → 'FRENTE' | 'DIREITA' | 'ESQUERDA' | 'CIMA'
~~~
### 3. Interpretação
O `Interpretador` percorre a AST e executa cada comando:
* Atualiza a posição do robô
* Controla o estado da caneta
* Desenha na grade quando a caneta está abaixada
* Exibe a grade final no console

## 🚀 Como Executar

### Pré-requisitos
* Java JDK 8 ou superior
* Terminal / PowerShell

### Compilar o Projeto
```bash
# No diretório projeto/
cd projeto
javac -source 8 -target 8 -d bin src/*.java
```
### Executar um Programa
Use um dos arquivos .rastro de exemplo (ex: quadrado.rastro) ou crie o seu.
```
# No diretório projeto/
java -cp bin Compilador quadrado.rastro
```
## 📚 Sintaxe da Linguagem
Comandos Disponíveis
### CANETA
Controla se o robô desenha ou não enquanto se move.
```
CANETA BAIXO  // Ativa o desenho
CANETA CIMA   // Desativa o desenho
```
### MOVER
Move o robô em uma direção por N passos.
```
MOVER FRENTE 5     // Move para frente 5 posições
MOVER DIREITA 3    // Move para direita 3 posições
MOVER ESQUERDA 2   // Move para esquerda 2 posições
MOVER CIMA 4       // Move para cima 4 posições
```
### REPETIR
Executa um bloco de comandos N vezes.
```
REPETIR 3 {
    MOVER FRENTE 2
    MOVER DIREITA 2
}
```
## 🧪 Testes
Os arquivos de teste estão incluídos no diretório `projeto/`:

* `arquivo.rastro` - Teste básico de movimentação
* `quadrado.rastro` - Desenha forma quadrada
* `exemplo_completo.rastro` - Exemplo com múltiplos comandos e comentários
Execute qualquer teste (ex: arquivo.rastro):
```
# Dentro do diretório projeto/
java -cp bin Compilador arquivo.rastro
```
