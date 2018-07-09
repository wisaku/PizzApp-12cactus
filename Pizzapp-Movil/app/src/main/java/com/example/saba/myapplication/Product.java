package com.example.saba.myapplication;

import java.io.Serializable;

class Product implements Serializable{

        private String nombre;
        private double precio;
        private Integer id;

        public Product(){}

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
}
