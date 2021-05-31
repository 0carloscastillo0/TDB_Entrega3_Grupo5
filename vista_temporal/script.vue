<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div id="app">
    <h1>{{mensaje}}</h1>
    <button @click="emergencia">Crear Emergencia</button>
    <button @click="crearTarea">Crear Tarea</button>
    <button @click="verEmergencia">Ver Emergencias</button>
    <button @click="verTarea">Ver Tareas</button>
    <button @click="status">Estados Emergencias</button>
    <button@click="log">Historial</button>
<!--------------------------------------------------->  
    
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

    </div> 
    
<!--------------------------------------------------->    
    
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
          <label for="miInput">Voluntarios Requeridos</label><br>
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
     
    </div>
    
<!--------------------------------------------------->    

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
    
<!--------------------------------------------------->    
    
    <div class="boxRightE" v-if="vistaLog">
      <label> Tareas Creadas </label><br>
      <div class="grayBoxLE">
        Log
      </div>
    </div>
    
    <div class="boxCenterE" v-if="vistaLog">
      <label> Tareas Iniciadas </label><br>
      <div class="grayBoxLE">
        Log
      </div>
    </div>    
    
    <div class="boxLeftE" v-if="vistaLog">
      <label> Tareas Finalizadas </label><br>
      <div class="grayBoxLE">
        Log
      </div>
    </div>    
    
  <!--------------------------------------------------->    

      
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
    
 <!--------------------------------------------------->    
     <div class="statusFL" v-if="vistaStatus">
       <label> Status Emergencia </label>
       <div class="statusBox">
       </div>
    </div>
    
     <div class="statusCL" v-if="vistaStatus">
       <label> Status Emergencia </label>
       <div class="statusBox">
       </div>
    </div> 
    
    <div class="statusFR" v-if="vistaStatus">
       <label> Status Emergencia </label>
       <div class="statusBox">
       </div>
    </div>
    
    <div class="statusCR" v-if="vistaStatus">
       <label> Status Emergencia </label>
       <div class="statusBox">
       </div>
    </div>
    
    
  </div>
</template>
<!--------------------------------------------------->    

<script>
  export default {
  data() {
    return {
      mensaje:'ChileVoluntarios',
      vistaEmergencia: false,
      vistaTarea: false,
      vistaActEmer: false,
      vistaActTarea: false,
      vistaLog: true,
      vistaStatus: false

    }
  },
  methods: {
    crearTarea(){
    this.vistaTarea=true;
    this.vistaEmergencia=false;
    this.vistaActEmer=false;
    this.vistaActTarea=false;
    this.vistaLog=false;
    this.vistaStatus=false;
    } ,
    emergencia(){
    this.vistaTarea=false;
    this.vistaEmergencia=true;
    this.vistaActEmer=false;
    this.vistaActTarea=false;
    this.vistaLog=false;
    this.vistaStatus=false;
    },
    log(){
        this.vistaTarea=false;
        this.vistaEmergencia=false;
        this.vistaActEmer=false;
        this.vistaActTarea=false;
        this.vistaLog=true;
        this.vistaStatus=false;
    },
    status(){
        this.vistaTarea=false;
        this.vistaEmergencia=false;
        this.vistaActEmer=false;
        this.vistaActTarea=false;
        this.vistaLog=false;
        this.vistaStatus=true;
    },
    verTarea(){
    this.vistaTarea=false;
    this.vistaEmergencia=false;
    this.vistaActEmer=false;
    this.vistaActTarea=true;
    this.vistaLog=false;
    this.vistaStatus=false;
    },
    verEmergencia(){
        this.vistaTarea=false;
        this.vistaEmergencia=false;
        this.vistaActEmer=true;
        this.vistaActTarea=false;
        this.vistaLog=false;
        this.vistaStatus=false;
    }

  }

};



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
  border-radius: 33px;
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
   border-radius: 33px;
}
  .boxCenterE{
    position: absolute;
    width: 372px;
    height: 414px;
    left: 399px;
    top: 170px;
    color: black;
    background: #ECEDC9;
    border-radius: 33px;
 }
    .boxLeftE{
    position: absolute;
    width: 372px;
    height: 414px;
    left: 15px;
    top: 170px;
    color: black;
    background: #ECEDC9;
    border-radius: 33px;
 }
 .cajaIzq{
   position: absolute;
   width: 308px;
   height: 45px;
   left: 115px;
   top: 110px;
   background: #f0f2c5;
   color: black;
   border-radius: 33px;
  }
 
  .cajaDer{
    position: absolute;
    width: 325px;
    height: 45px;
    left: 534px;
    top: 110px;
    background: #f0f2c5;
    color: black;
    border-radius: 33px;
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
    border-radius: 33px;
  }
  
  .grayBoxR{
    position: absolute;
    width: 395px;
    height: 314px;
    left: 30px;
    top: 90px;
    background: #C4C4C4;
    color: black;
    border-radius: 33px;
  }
  
    .grayBoxLE{
    position: absolute;
    width: 300px;
    height: 314px;
    left: 30px;
    top: 90px;
    background: #C4C4C4;
    color: black;
    border-radius: 33px;
  }
  
  
  .statusFL{
    position: absolute;
    width: 231px;
    height: 414px;
    left: 80px;
    top: 160px;
    color: black;
    background: #ECEDC9;
    border-radius: 33px;
  }
  
  .statusCL{
    position: absolute;
    width: 231px;
    height: 414px;
    left: 346px;
    top: 160px;
    background: #ECEDC9;
    color: black;
    border-radius: 33px;
  }
  
  .statusCR{
    position: absolute;
    width: 231px;
    height: 420px;
    left: 615px;
    top: 160px;
    color: black;
    background: #ECEDC9;
    border-radius: 33px;
  }
  
  .statusFR{
    position: absolute;
    width: 231px;
    height: 420px;
    left: 884px;
    top: 160px;
    color: black;
    background: #ECEDC9;
    border-radius: 33px;
  }
  
  .statusBox{
    position: absolute;
    width: 200px;
    height: 360px;
    left: 15px;
    top: 39px;
    color: black;
    background: #C4C4C4;
    border-radius: 33px;
  }
  
</style>