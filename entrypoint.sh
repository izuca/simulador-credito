#!/bin/bash
/opt/mssql/bin/sqlservr &

# espera o SQL subir
sleep 20s
echo ">> Executando script de inicialização no SQL Server..."
/opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P $SA_PASSWORD -d master -C -i /init.sql
echo ">> Script executado com sucesso!"
wait
