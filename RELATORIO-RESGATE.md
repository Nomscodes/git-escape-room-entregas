# Relatório de Resgate

- **Equipe:** Gabriel Naoki (Resgate), Caio Abreu (Investigador Git), Wyllian Mariano (Responsável Técnico), Cassiano Abreu (Relator/Apresentador)
- **Branch de trabalho:** resgate/discente-gabriel-naoki-caio-abreu-wyllian-mariano-cassiano-abreu

## Diagnóstico

### Problemas Encontrados e Evidências

1. **Compilação falhando (7 erros)**
   - Classe `Validador.java` foi deletada no commit `64f88f6`
   - Construtor de `Mercadoria` esperava 7 parâmetros (incluindo `endereco`), mas recebia 6
   - Método `repository.gravar()` não existia (correto: `salvar()`)
   - Evidência: `mvn clean package` retornava BUILD FAILURE

2. **Lógica de autenticação bugada (LoginService.java:8)**
   - Usava `||` (OR) em vez de `&&` (AND)
   - Comparava String com `==` em vez de `.equals()`
   - Resultado: Aceitava credenciais parcialmente corretas
   - Evidência: `autenticar("admin", "QUALQUER_COISA")` retornava true

3. **Arquivo excluído**
   - `Validador.java` foi deletado indevidamente
   - Localizado via `git log --all --diff-filter=D`

4. **Credenciais expostas (application.properties)**
   - `db.password=SuperSenha123`
   - `api.token=TOKEN-NAO-DEVERIA-ESTAR-NO-GIT`
   - Adicionadas no commit `6572d8a` (tag: commit-perigoso)

5. **README inadequado**
   - Conteúdo: "Sistema interno. Pergunte ao desenvolvedor como executar."
   - Sem instruções de compilação, execução ou documentação da arquitetura

## Comandos Git utilizados

| Comando | Finalidade |
|---------|-----------|
| `git log --all --diff-filter=D --summary` | Localizar arquivos deletados |
| `git show 64f88f6 -- "src/main/java/br/edu/entregas/util/"` | Visualizar o que foi deletado |
| `git show 64f88f6^:src/main/java/br/edu/entregas/util/Validador.java` | Recuperar arquivo de versão anterior |
| `git checkout 64f88f6^ -- src/main/java/br/edu/entregas/util/Validador.java` | Restaurar arquivo deletado |
| `git add .` | Adicionar mudanças à staging area |
| `git commit -m "..."` | Criar commits documentando cada correção |
| `git checkout main` | Mudar para branch main |
| `git merge resgate/...` | Fazer merge da branch de resgate na main |
| `git push -u origin resgate/...` | Fazer push da branch de resgate |
| `git push origin main` | Fazer push das mudanças na main |
| `mvn clean package` | Compilar e validar o projeto |

## Commits relevantes

| Hash | Mensagem | Detalhes |
|------|----------|---------|
| e0dfb44 | fix: restaurar classe Validador e corrigir EntregaService | Recuperou Validador.java, adicionou `endereco` ao construtor, trocou `gravar()` por `salvar()` |
| f07fc11 | fix: corrigir lógica de autenticação no LoginService | Trocou `\|\|` por `&&`, usou `.equals()` para String |
| 2ce0609 | docs: melhorar README com instruções de execução | Adicionou requisitos, instruções de compilação/execução, arquitetura e funcionalidades |
| 4a28837 | security: remover credenciais expostas do arquivo de configuração | Removeu senha e token de `application.properties` |

## Validação final

### ✅ Compilação

mvn clean package → BUILD SUCCESS
- Projeto compila sem erros
- JAR gerado: `target/projeto-entregas-1.0.0.jar`

### ✅ Login
- `admin / 12345678` → Autentica com sucesso ✓
- `admin / SENHA_ERRADA` → Rejeita ✓
- `USUARIO_ERRADO / 12345678` → Rejeita ✓

### ✅ Cadastro
- Cria mercadoria com todos os 7 parâmetros obrigatórios
- Endereço é obrigatório (validação confirmada)
- Validador valida nome, descrição, peso e valor

### ✅ README
- Documenta requisitos (Java 17+, Maven 3.6+)
- Explica como compilar e executar
- Descreve arquitetura em 3 camadas
- Lista funcionalidades e estrutura do projeto

### ✅ Segurança
- `application.properties` contém apenas configurações públicas
- Credenciais removidas do arquivo
- Histórico mantém registro para auditoria (commit `6572d8a` ainda acessível)

**Status Final:** 🎉 ESCAPE ROOM COMPLETO - Projeto pronto para entrega!
