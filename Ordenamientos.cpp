#ifndef OrdenamientosAngel
#define  OrdenamientosAngel
#include <bits/stdc++.h>
  namespace Ordenamientos{
    using namespace std;
    class Ordenamiento{
    private:
      static void merge(vector<int> &v, int menor, int centro, int mayor){
        vector<int> A;
        vector<int> B;
        for(int i = 0; i < centro - menor + 1; ++i) A.push_back(v.at(menor + i));
        for(int i = 0; i < mayor -centro; ++i) B.push_back(v.at(centro + i + 1));
        int i = menor;
        while(!A.empty() && !B.empty()){
          if(A.front() <= B.front()){
            v[i] = A.front();
            A.erase(A.begin());
          }
          else{
            v[i] = B.front();
            B.erase(B.begin());
          }
          ++i;
        }
        while(!A.empty()){
          v[i] = A.front();
          A.erase(A.begin());
          ++i;
        }
        while(!B.empty()){
          v[i] = B.front();
          B.erase(B.begin());
          ++i;
        }
      }
      static int pvt(vector<int> &v,int pvtIzq, int pvtDer){
        int pivote = v.at(pvtIzq);
        int izq = pvtIzq;
        int der = pvtDer;
        while(izq < der){
              for(; v.at(der) > pivote; --der){}
              for(; izq <der && v.at(izq) <= pivote; ++izq){}
              if(izq <der)
              swap(v[izq], v[der]);
          }
          swap(v[pvtIzq], v[der]);
          return izq;
      }
    public:
      static void burbuja(vector<int> &v){
        for(int i = 0; i < (int) v.size() - 1; ++i){
          for(int j = 1; j < v.size() - i; ++j)
            if(v.at(j) < v.at(j - 1)) swap(v[j], v[j- 1]);
        }
      }
      static void insercion(vector<int>&v){
        for(int i = 0; i < (int) v.size(); ++i){
          int j = i - 1;
          int aux = v.at(i);
          while(j >= 0 && v.at(j) < aux){
            v[j + 1] = v.at(j);
            --j;
          }
          v[j + 1] = aux;
        }
      }
      static void mSort(vector<int> &v, int menor, int mayor){
        if(menor < mayor){
          int centro = (menor + mayor) / 2;
          mSort(v, menor, centro);
          mSort(v, centro + 1, mayor);
          merge(v, menor, centro, mayor);
        }
      }
      static void qSort(vector<int>&v, int pvtIzq, int pvtDer){
        if(pvtIzq < pvtDer){
          int pivote = pvt(v, pvtIzq, pvtDer);
          qSort(v, pvtIzq, pivote - 1);
          qSort(v,pivote + 1, pvtDer);
        }
      }
    };
  };
#endif
int main(int argc, char const *argv[]) {
  /* code */
  return 0;
}
