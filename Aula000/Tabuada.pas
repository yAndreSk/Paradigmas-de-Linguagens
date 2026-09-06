program Tabuada;

var
  Numero, I: Integer;

begin
  Write('Digite um numero: ');
  Readln(Numero);

  Writeln;
  Writeln('Tabuada do ', Numero, ':');
  Writeln;

  for I := 1 to 10 do
    Writeln(Numero, ' x ', I, ' = ', Numero * I);

  Readln;
end.
