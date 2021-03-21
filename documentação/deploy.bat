cd ..
call mvn clean install test
echo **************************************
echo *                                    *
echo * Build concluido *
echo *                                    *
echo * Inicializando Aplicacao *
echo **************************************

cd target
call java -jar simulado-0.0.1-SNAPSHOT.jar

echo **************************************
echo *                                    *
echo * Aplicacao encerrada *
echo *                                    *
echo **************************************