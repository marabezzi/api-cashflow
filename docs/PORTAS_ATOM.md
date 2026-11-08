# Registro de portas ATOM — 2026-11-07

Esta aplicação reserva portas **exclusivas no host** para coexistir com outros sistemas ATOM no mesmo computador. Portas **internas** de contêineres isolados podem se repetir.

## Este repositório

API Spring Boot 8110; PostgreSQL publicado no host em 5440 e interno em 5432. Variáveis API_PORT e DB_PORT controlam mapeamentos do Docker. O servidor nativo aceita SERVER_PORT.

## Verificação no computador

```bash
docker ps --format 'table {{.Names}}\t{{.Ports}}'
sudo ss -ltnp
```

Não execute stacks simultâneos com mapeamentos coincidentes. Revise os arquivos `.env` locais: valores definidos neles prevalecem sobre padrões do repositório.

**HTTPS em produção:** apenas um gateway/proxy deve ocupar 80/443 no mesmo IP; mantenha os ingressos existentes até configurar um proxy compartilhado. Alterar portas públicas pode invalidar desafios ACME/Let's Encrypt e requer homologação antes do merge.
