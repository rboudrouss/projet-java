echo "Compiling files..."
javac src/*.java -d bin
echo "Files compiled to bin."

echo "executing program"
cd ./bin/; java Main; cd ..