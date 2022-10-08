#include <iostream>
#include "Proffesor.cpp"
using namespace std;


class Grupo{
private:
    Profesor profesor;
    string horario;
    int NoGrupo;

public:
    Grupo() {

    }

    Grupo(Profesor profesor, string horario, int NoGrupo) : profesor(profesor), horario(horario), NoGrupo (NoGrupo) {

    }

    Profesor getProfesor() {
        return profesor;
    }

    void setProfesor(Profesor profesor) {
        this->profesor = profesor;
    }

    string getHorario() {
        return horario;
    }

    void setHorario(string horario) {
        this->horario = horario;
    }

    int getNoGrupo() {
        return NoGrupo;
    }

    void setNoGrupo(int NoGrupo) {
        this->NoGrupo = NoGrupo;
    }
};
