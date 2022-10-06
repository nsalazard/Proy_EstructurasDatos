#include <iostream>
#include <string>
using namespace std;

class Profesor{
private:
    string nombre;
    float puntaje;

public:
    Profesor(){

    }

    Profesor(string nombre, float puntaje) : nombre(nombre) , puntaje(puntaje) {

    }

    string getNombre() {
        return nombre;
    }

    void setNombre(string nombre) {
        this->nombre = nombre;
    }

    float getPuntaje() {
        return puntaje;
    }

    void setPuntaje(float puntaje) {
        this->puntaje = puntaje;
    }

    bool operator < (Profesor that) {
        return this->puntaje < that.getPuntaje();
    }

    bool operator == (Profesor that) {
        return (this->puntaje == that.getPuntaje() && this->nombre.compare(that.getNombre()) == 0);
    }
};
