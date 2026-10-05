\# Git Escape Room - Projeto Entregas



\## Equipe



\- Gabriel Naoki Uto Turigoe — Responsável pelo Resgate

\- Caio Abreu — Investigador Git

\- Wyllian Mariano — Responsável Técnico

\- Cassiano Abreu — Relator/Apresentador



\*\*Branch de trabalho:\*\* resgate/discente-gabriel-naoki-caio-abreu-wyllian-mariano-cassiano-abreu



\---



\## Status Final



\### ESCAPE ROOM COMPLETAMENTE RESOLVIDO ✓



\- 6/6 Portas Desbloqueadas

\- 3 Commits de Resgate Implementados

\- 3 Pull Requests Mergeados na Main

\- 100% dos Critérios Atendidos



\---



\## As 6 Portas do Escape Room



\### Porta 1 — Compilação Falhando



\*\*Problema:\*\* Classe Validador.java deletada, impedindo compilação do projeto



\*\*Causa:\*\* Commit 64f88f6 (Igor Reis) — "refactor: remover classe aparentemente sem uso"



\*\*Evidência:\*\* mvn clean package retornava BUILD FAILURE com 7 erros



\*\*Solução:\*\* Recuperar arquivo do commit anterior (64f88f6^) usando git checkout



\*\*Resultado:\*\* ✓ BUILD SUCCESS



\---



\### Porta 2 — Arquivo Excluído



\*\*Problema:\*\* Arquivo Validador.java faltando no projeto



\*\*Arquivo:\*\* src/main/java/br/edu/entregas/util/Validador.java



\*\*Causa:\*\* Deletado no commit 64f88f6 (Igor Reis)



\*\*Solução:\*\* Recuperação automática na Porta 1 (mesmo arquivo, mesmo comando)



\*\*Resultado:\*\* ✓ Arquivo restaurado e compilando



\---



\### Porta 3 — Login Bugado



\*\*Problema:\*\* Autenticação aceitava credenciais parcialmente corretas



\*\*Código Original (ERRADO):\*\*

```java

return USUARIO.equals(usuario) || senha == SENHA;

```



\*\*Erros Identificados:\*\*

\- Operador || (OR) em vez de \&\& (AND)

\- Comparação == em vez de .equals() para String



\*\*Autor do Bug:\*\* Felipe Rocha — Commit 9a6d3b0 — "fix: liberar login para homologacao"



\*\*Impacto:\*\* Acesso não autorizado possível com apenas um parâmetro correto



\*\*Código Corrigido:\*\*

```java

return USUARIO.equals(usuario) \&\& SENHA.equals(senha);

```



\*\*Validação:\*\*

\- Login admin/12345678 → ✓ Acesso autorizado

\- Login admin/errada → ✓ Acesso negado

\- Login x/12345678 → ✓ Acesso negado



\*\*Resultado:\*\* ✓ Autenticação funcionando corretamente



\---



\### Porta 4 — README Inadequado



\*\*Problema:\*\* Documentação insuficiente e inadequada



\*\*Conteúdo Original:\*\* "Sistema interno. Pergunte ao desenvolvedor como executar."



\*\*Falta de:\*\* Requisitos, instruções de compilação, instruções de execução, credenciais



\*\*Autor:\*\* Gustavo Melo — Commit 0cd80f6 — "docs: simplificar readme"



\*\*Solução:\*\* Recuperar README funcional da branch docs-readme usando git show origin/docs-readme:README.md



\*\*README Corrigido Inclui:\*\*

\- Requisitos (Java 17+, Maven 3.8+)

\- Compilação: mvn clean package

\- Execução: java -cp target/classes br.edu.entregas.Main

\- Credenciais padrão: admin / 12345678

\- Modelo: Cada mercadoria possui endereço de entrega



\*\*Resultado:\*\* ✓ Documentação profissional e completa



\---



\### Porta 5 — Segurança (Credenciais Expostas)



\*\*Problema:\*\* Dados sensíveis versionados em config/application.properties



\*\*Arquivo Afetado:\*\* config/application.properties



\*\*Credenciais Expostas:\*\*

\- db.password=SuperSenha123

\- api.token=TOKEN-NAO-DEVERIA-ESTAR-NO-GIT



\*\*Autor:\*\* Felipe Rocha — Commit 6572d8a (TAG: commit-perigoso) — "chore: salvar credenciais para facilitar testes"



\*\*Impacto:\*\* Credenciais acessíveis no histórico Git público



\*\*Solução:\*\*

\- Remover arquivo da versão atual com git rm --cached config/application.properties

\- Adicionar .env e config/application.properties ao .gitignore

\- Preservar histórico para auditoria (credenciais permanecem em 6572d8a)



\*\*Aviso de Segurança:\*\* As credenciais originais (SuperSenha123, TOKEN-NAO-DEVERIA-ESTAR-NO-GIT) devem ser consideradas comprometidas. Recomenda-se revogar credenciais originais e usar novas em produção.



\*\*Resultado:\*\* ✓ Credenciais removidas da versão atual, .gitignore atualizado



\---



\### Porta 6 — Dependência Não Prevista



\*\*Problema:\*\* PRs posteriores introduziram biblioteca dotenv-java que não estava prevista



\*\*Commits Problemáticos:\*\*

\- 592f48a (Laboratorio Git) — "fix: ler credenciais de variáveis de ambiente em vez de hardcoded"

\- 4968aaf (Laboratorio Git) — "fix: remove hardcoded credentials from README"



\*\*Impacto:\*\*

\- Comando do enunciado java -cp target/classes br.edu.entregas.Main não funcionava

\- Sistema quebrava sem .env ou sem a lib no classpath

\- Incompatibilidade com o escopo original



\*\*Solução:\*\*

\- Remover dependência dotenv-java do pom.xml

\- Restaurar LoginService com constantes hardcoded (admin/12345678)

\- Restaurar README com credenciais padrão



\*\*Resultado:\*\* ✓ Sistema funciona conforme enunciado



\---



\## Commits de Resgate Implementados



| Hash | Autor | Data | Mensagem | Detalhes |

|------|-------|------|----------|----------|

| 267b9a1 | Gabriel Naoki | 04/10/2026 19:00 | fix: restaurar login corrigido e remover dependencia .env | Restaura LoginService com \&\& e .equals(), remove dotenv-java |

| ef12f08 | Gabriel Naoki | 04/10/2026 19:15 | docs: recuperar README funcional da branch docs-readme | Recupera README funcional com requisitos e credenciais |

| 6946162 | Gabriel Naoki | 04/10/2026 19:33 | security: atualizar .gitignore e remover config/application.properties | Remove arquivo de config, adiciona .env ao .gitignore |



\---



\## Commits Investigados no Histórico (Problemas Originais)



| Hash | Autor | Mensagem | Impacto | Porta |

|------|-------|----------|---------|-------|

| 64f88f6 | Igor Reis | refactor: remover classe aparentemente sem uso | Deletou Validador.java | 1 e 2 |

| a70ee84 | Henrique Nunes | feat: acelerar cadastro de mercadorias | Alterou parâmetros de EntregaService | Investigação |

| 0cd80f6 | Gustavo Melo | docs: simplificar readme | Removeu documentação | 4 |

| 6572d8a | Felipe Rocha | chore: salvar credenciais para facilitar testes | Adicionou credenciais expostas | 5 |

| 9a6d3b0 | Felipe Rocha | fix: liberar login para homologacao | Bug no LoginService (|| e ==) | 3 |

| 592f48a | Laboratorio Git | fix: ler credenciais de variáveis de ambiente | Adicionou dotenv-java | 6 |



\---



\## Comandos Git Utilizados



\### Investigação

\- git log --oneline --all --graph --decorate

\- git log --format='%h %an %s'

\- git show <hash>:<arquivo>

\- git diff <arquivo>



\### Recuperação

\- git checkout <commit> -- <arquivo>

\- git show origin/docs-readme:README.md > README.md

\- git log --all --diff-filter=D



\### Trabalho em Branch

\- git switch -c resgate/discente-ajustes-finais

\- git add <arquivo>

\- git commit -m "mensagem"

\- git push origin resgate/discente-ajustes-finais



\### Integração

\- git switch main

\- git pull origin main

\- git merge --no-ff <branch>



\---



\## Validação Final



\### Compilação

\- \*\*Comando:\*\* mvn clean package

\- \*\*Resultado:\*\* BUILD SUCCESS

\- \*\*Status:\*\* ✓ PASSOU



\### Autenticação (LoginService)



\*\*Teste 1 — Credenciais Válidas\*\*

\- Usuário: admin

\- Senha: 12345678

\- Esperado: Acesso autorizado

\- Obtido: ✓ Acesso autorizado. Mercadoria com endereço exibida

\- Status: ✓ PASSOU



\*\*Teste 2 — Senha Incorreta\*\*

\- Usuário: admin

\- Senha: errada

\- Esperado: Acesso negado

\- Obtido: ✓ Acesso negado

\- Status: ✓ PASSOU



\*\*Teste 3 — Usuário Incorreto\*\*

\- Usuário: x

\- Senha: 12345678

\- Esperado: Acesso negado

\- Obtido: ✓ Acesso negado

\- Status: ✓ PASSOU



\### Cadastro de Mercadoria

\- Todos os atributos presentes: id, nome, descrição, peso, valor, status, endereco

\- Endereço obrigatório: ✓ Confirmado

\- Exemplo de saída: #1 | Notebook | Notebook corporativo | 2.1 kg | R$ 4500,00 | AGUARDANDO ENVIO | Entrega: Av. Goiás, 1000 - Sala 8, Goiânia/GO - CEP: 74000-000

\- Status: ✓ PASSOU



\### README

\- Requisitos documentados: ✓ Java 17+, Maven 3.8+

\- Instruções de compilação: ✓ mvn clean package

\- Instruções de execução: ✓ java -cp target/classes br.edu.entregas.Main

\- Credenciais padrão: ✓ admin / 12345678

\- Modelo explicado: ✓ Cada mercadoria com endereço

\- Status: ✓ PASSOU



\### Segurança

\- Arquivo config/application.properties removido do versionamento: ✓

\- .gitignore atualizado (.env e config/application.properties): ✓

\- Credenciais não em novos commits: ✓

\- Histórico preservado para auditoria: ✓

\- Status: ✓ PASSOU



\---



\## Resumo de Validação



| Critério | Resultado | Status |

|----------|-----------|--------|

| mvn clean package | BUILD SUCCESS | ✓ |

| Login admin/12345678 | Acesso autorizado com mercadoria | ✓ |

| Login admin/errada | Acesso negado | ✓ |

| Login x/12345678 | Acesso negado | ✓ |

| Cadastro com endereço | Exibido corretamente | ✓ |

| README | Instruções completas | ✓ |

| Segurança | Credenciais removidas | ✓ |

| Histórico | Preservado sem force push | ✓ |



\---



\## Branches e Repositório



\*\*Branch de Resgate:\*\* resgate/discente-ajustes-finais



\*\*Branch Principal:\*\* main (atualizada com todas as correções)



\*\*Pull Requests Mergeados:\*\*

\- PR #6 — fix: restaurar login corrigido e remover dependencia dotenv

\- PR #7 — docs: recuperar README funcional da branch docs-readme

\- PR #8 — security: atualizar .gitignore e remover config/application.properties

\- PR #9 — docs: preencher relatório final do resgate



\*\*Repositório:\*\* https://github.com/Nomscodes/git-escape-room-entregas



\---



\## Conclusão



O Git Escape Room foi completamente resolvido. Os 6 problemas foram identificados através de investigação cuidadosa do histórico Git, recuperados usando comandos apropriados e testados rigorosamente. Toda a solução foi documentada conforme padrão do professor.



A equipe demonstrou competência em:

\- Análise de histórico Git

\- Identificação de bugs e problemas

\- Recuperação de arquivos e estados anteriores

\- Gestão de segurança e boas práticas

\- Documentação profissional

\- Integração com Pull Requests e merge commits



\*\*ESCAPE ROOM: COMPLETAMENTE RESOLVIDO ✓\*\*

