package com.example.d4aspostrecitos.model

class Producto(
    var idProducto: Long? = null,
    var nombre: String? = null,
    var fotoUrl: String? = null,
    var precio: Double? = null,
    var descripcion: String? = null,
    var isActive: Char = 'A',
    var categoria: Categoria? = null
) {
    // Getters y Setters manuales (aunque Kotlin los genera automáticamente)
    // si prefieres definirlos explícitamente, puedes hacerlo así

    // Getter y Setter para idProducto
    fun getIdProducto(): Long? {
        return idProducto
    }

    fun setIdProducto(id: Long?) {
        this.idProducto = id
    }

    // Getter y Setter para nombre
    fun getNombre(): String? {
        return nombre
    }

    fun setNombre(nombre: String?) {
        this.nombre = nombre
    }

    // Getter y Setter para fotoUrl
    fun getFotoUrl(): String? {
        return fotoUrl
    }

    fun setFotoUrl(fotoUrl: String?) {
        this.fotoUrl = fotoUrl
    }

    // Getter y Setter para precio
    fun getPrecio(): Double? {
        return precio
    }

    fun setPrecio(precio: Double?) {
        this.precio = precio
    }

    // Getter y Setter para descripcion
    fun getDescripcion(): String? {
        return descripcion
    }

    fun setDescripcion(descripcion: String?) {
        this.descripcion = descripcion
    }

    // Getter y Setter para isActive
    fun getIsActive(): Char {
        return isActive
    }

    fun setIsActive(isActive: Char) {
        this.isActive = isActive
    }

    // Getter y Setter para categoria
    fun getCategoria(): Categoria? {
        return categoria
    }

    fun setCategoria(categoria: Categoria?) {
        this.categoria = categoria
    }
}
