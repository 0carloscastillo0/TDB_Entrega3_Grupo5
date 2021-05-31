<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div id="app">
    <h1>{{mensaje}}</h1>
    <button @click="doSomething">Crear Emergencia</button>
    <button>Crear Tarea</button>
    <button>Acciones De Emergencia</button>
    <button>Acciones En Tareas</button>
    
    <div class="box" v-if="vistaEmergencia">
      <p>Vista Emergencia</p>
      <form>
        <div class="cajaIzq">
          <label for="miInput">Nombre Emergencia</label><br>
          <input id="nombreE" size="30" v-model="texto" type="text">
        </div>
        <div class="cajaDer">
          <label for="miInput">Nombre Institucion</label><br>
          <input id="nombreI" size="30" v-model="texto" type="text">
        </div>
        <div class="cajaAbaIzq">
          <label for="miInput">Descripcion Emergencia</label><br>
          <textarea id="descripcionE" name="descripcionE" rows="7" cols="40">
          </textarea>
        </div>
        <div class="cajaAbaDer">
          <label for="miInput">Descripcion Institucion</label><br>
          <textarea id="descripcionI" name="descripcionI" rows="7" cols="40">
          </textarea>
        </div>
      </form>
      <button> Crear </button>
      <button> Volver </button>
    </div>  
    
    <div class="box" v-if="vistaTarea">
      Vista Tarea
      <form>
        <div class="cajaIzq">
          <label for="miInput">Nombre Tarea</label><br>
          <input id="nombreE" size="30" v-model="texto" type="text">
        </div>
        <div class="cajaAbaIzq">
          <label for="miInput">Descripcion Tarea</label><br>
          <textarea id="descripcionE" name="descripcionE" rows="7" cols="40">
          </textarea>
        </div>
        <div class="volRequerido">
          <label for="miInput">Voluntarios Reqeridos</label><br>
          <input id="nombreE" size="10" v-model="numero" type="number">
        </div>
        <div class="fechaIni">
          <label for="miInput">Fecha Inicio</label><br>
          <input id="fechaI" size="30" v-model="fecha" type="date">
        </div>
        <div class="fechaFin">
          <label for="miInput">Fecha Termino</label><br>
          <input id="fechaF" size="30" v-model="fecha" type="date">
        </div>
        
      </form>
      <button> Crear </button>
      <button> Volver </button>
    </div>
    
    <div class="boxRightE" v-if="vistaActEmer">
      <label> Emergencia a Finalizar </label><br>
      <div class="grayBoxLE">
        Emergencias a Finalizar
      </div>
      <button> Finalizar </button>
    </div>
    
    <div class="boxCenterE" v-if="vistaActEmer">
      <label> Emergencia a Cancelar </label><br>
      <div class="grayBoxLE">
        Emergencias a Cancelar
      </div>
      <button> Cancelar </button>
    </div>    
    
    <div class="boxLeftE" v-if="vistaActEmer">
      <label> Emergencia a Iniciar </label><br>
      <div class="grayBoxLE">
        Emergencias a Iniciar
      </div>
      <button> Iniciar </button>
    </div>    
    
    
    
    
    
    <div class="boxLeft" v-if="vistaActTarea">
      <br>Tareas a Iniciar<br>
      <div class="grayBoxL">
        <label> Tareas Activas </label>
      </div>
      <button> Iniciar </button>
    </div>
    
    <div class="boxRight" v-if="vistaActTarea">
      <br>Tareas a Terminar<br>
      <div class="grayBoxL">
        <label> Tareas Activas </label>
      </div>
      <button> Terminar </button>
    </div>
    
  </div>
</template>

<script>
  export default {
  data() {
    return {
      mensaje:'ChileVoluntarios',
      vistaEmergencia: false,
      vistaTarea: false,
      vistaActEmer: false,
      vistaActTarea: true

    }
  },
  methods: {
        doSomething() {
          alert("SDSDS");
    }
  }
};
 var vista = new Vue({
  el: '#app',
  data: {

  },
  // define methods under the `methods` object
  methods: {

  }
})

</script>

<!-- Use preprocessors via the lang attribute! e.g. <style lang="scss"> -->
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #DBDBEA;
  margin-top: 60px;
  position: absolute;
  width: 1261px;
  height: 140px;
  left: 0px;
  top: 0px;
  background: #4B4F9A;
  border: 1px solid #000000;
  box-sizing: border-box;
  
}

a,
button {
  color: white;
}

button {
  background: #25274C;
  border: solid 1px;
  border-radius: 2em;
  font: inherit;
  padding: 0.75em 2em;
}
  
  fondo{
    position: absolute;
    width: 1261px;
    height: 150px;
    left: 0px;
    top: 611px;
    background: #ECEDC9;
  }
  
.box {
  position: absolute;
  width: 978px;
  height: 447px;
  left: 156px;
  top: 153px;
  background: #ECEDC9;
}
  .boxLeft {
  position: absolute;
  width: 450px;
  height: 447px;
  left: 156px;
  top: 153px;
  background: #ECEDC9;
  color: black;
}
  .boxRight {
  position: absolute;
  width: 450px;
  height: 447px;
  left: 656px;
  top: 153px;
  background: #ECEDC9;
  color: black;
}
  
 .boxRightE {
    position: absolute;
    width: 372px;
    height: 414px;
    left: 783px;
    top: 170px;
    color: black;
    background: #ECEDC9;
}
  .boxCenterE{
    position: absolute;
    width: 372px;
    height: 414px;
    left: 399px;
    top: 170px;
    color: black;
    background: #ECEDC9;
 }
    .boxLeftE{
    position: absolute;
    width: 372px;
    height: 414px;
    left: 15px;
    top: 170px;
    color: black;
    background: #ECEDC9;
 }
 .cajaIzq{
   position: absolute;
   width: 308px;
   height: 45px;
   left: 115px;
   top: 110px;
   background: #f0f2c5;
   color: black;
  }
 
  .cajaDer{
    position: absolute;
    width: 325px;
    height: 45px;
    left: 534px;
    top: 110px;
    background: #f0f2c5;
    color: black;
  }
  
  .cajaAbaIzq{
    position: absolute;
    width: 308px;
    height: 152px;
    left: 115px;
    top: 191px;
    background: #f0f2c5;
    resize: none;
    color: black;
  }
  
  .cajaAbaDer{
    position: absolute;
    width: 323px;
    height: 153px;
    left: 536px;
    top: 190px;
    background: #f0f2c5;
    resize: none;
    color: black;
  }
  
  .volRequerido{
    position: absolute;
    width: 308px;
    height: 45px;
    left: 115px;
    top: 380px;
    background: #f0f2c5;
    color: black;
  }
  
  .fechaIni{
    position: absolute;
    width: 147px;
    height: 45px;
    left: 600px;
    top: 191px;
    background: #f0f2c5;
    color: black;
  }
  
  .fechaFin{
    position: absolute;
    width: 147px;
    height: 45px;
    left: 600px;
    top: 281px;
    background: #f0f2c5;
    color: black;
  }
  
  .grayBoxL{
    position: absolute;
    width: 395px;
    height: 314px;
    left: 30px;
    top: 90px;
    background: #C4C4C4;
    color: black;
  }
  
  .grayBoxR{
    position: absolute;
    width: 395px;
    height: 314px;
    left: 30px;
    top: 90px;
    background: #C4C4C4;
    color: black;
  }
  
    .grayBoxLE{
    position: absolute;
    width: 300px;
    height: 314px;
    left: 30px;
    top: 90px;
    background: #C4C4C4;
    color: black;
  }
  
</style>