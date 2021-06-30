<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div id="app">
    <h1>{{mensaje}}</h1>
    <button @click="emergencia">Crear Emergencia</button>
    <button @click="crearTarea">Crear Tarea</button>
    <button @click="verEmergencia">Ver Emergencias</button>
    <button @click="verTarea">Ver Tareas</button>
    <button @click="status">Estados Emergencias</button>
    <button @click="log">Historial</button>
<!--------------------------------------------------->  
    
    -------------------------------------------------->  
    
    <div class="box" v-if="vistaEmergencia">
      <p>Vista Emergencia</p>
      <form>
        <div class="cajaIzq">
          <label for="miInput">Nombre Emergencia</label><br>
          <input id="nombre" size="30" v-model="newEmergencia.nombre_emergencia" type="text">
        </div>
        <div class="cajaDer">
          <select name="cars" id="cars" v-model="newEmergencia.id_institucion">
            <option value="1">Bomberos</option>
            <option value="2">Cruz Roja</option>
            <option value="3">Voluntariado USACH</option>
            <option value="4">Hermanas de Chicureo</option>
            <option value="5">Santa Maria</option>
            <option value="6">Manos Mormonas</option>
            <option value="7">Fundacion San Vicente</option>
          </select>
        </div>
        <div class="cajaAbaIzq">
          <label for="miInput">Descripcion Emergencia</label><br>
          <textarea id="descripcion" name="descripcion" v-model="newEmergencia.descripcion_emergencia" rows="7" cols="40"> 
          </textarea>
        </div>
        
      </form>
      <button @click="enviarE"> Crear </button> 
      <button> Volver </button>
    </div> 
    
    
<!--------------------------------------------------->    
    
    <div class="box" v-if="vistaTarea">
      Vista Tarea
      <form>
        <div class="cajaIzq">
          <label for="miInput">Nombre Tarea</label><br>
          <input id="nombreT" size="30" v-model="newTarea.nombre_tarea" type="text">
        </div>
        <div class="cajaAbaIzq">
          <label for="miInput">Descripcion Tarea</label><br>
          <textarea id="descripcionE" name="descripcionE" v-model="newTarea.descripcion_tarea" rows="7" cols="40">
          </textarea>
        </div>
        <div class="volRequerido">
          <label for="miInput">Voluntarios Requeridos</label><br>
          <input id="nombreE" size="10" v-model="newTarea.cant_vol_requeridos" type="number">
        </div>
        <div class="fechaIni">
          <label for="miInput">Fecha Inicio</label><br>
          <input id="fechaI" size="30" v-model="newTarea.inicio" type="date">
        </div>
        <div class="fechaFin">
          <label for="miInput">Fecha Termino</label><br>
          <input id="fechaF" size="30" v-model="newTarea.fin" type="date">
        </div>
        
      </form>
      <button @click="enviarT"> Crear </button> 
      <button> Crear </button>
     
    </div>
    
<!--------------------------------------------------->    

    <div class="boxRightE" v-if="vistaActEmer">
      <label> Emergencia a Finalizar </label><br>
      <div class="grayBoxLE">
      <!--Mostrar Emergencias con estado "2"-->
      
          <ul class="item-list">
            <li v-for="(e3, index) in emergencias3" :key="index">
              {{e3.nombre_emergencia}}
            </li>
          </ul>
    
      </div>
      <button> Finalizar </button>
    </div>
    
    <div class="boxCenterE" v-if="vistaActEmer">
      <label> Emergencia a Cancelar </label><br>
      <div class="grayBoxLE">
      <!--Mostrar Emergencias con estado "2"-->

        <ul class="item-list">
          <li v-for="(e2, index) in emergencias2" :key="index">
            {{e2.nombre_emergencia}}
          </li>
        </ul>
    
      </div>
      <button> Cancelar </button>
    </div>    
    
    <div class="boxLeftE" v-if="vistaActEmer">
      <label> Emergencia a Iniciar </label><br>
      <div class="grayBoxLE">
      <!--Mostrar Emergencias con estado "1"-->
        
        <ul class="item-list">
          <li v-for="(e1, index) in emergencias1" :key="index">
            {{e1.nombre_emergencia}}
          </li>
        </ul>
     
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
        <label> Tareas No Activas </label>
        <!--Mostrar Tareas con estado "1"-->
          
          <ul class="item-list">
            <li v-for="(t1, index) in tareas1" :key="index">
              {{t1.nombre_tarea}}
            </li>
          </ul>
        
      </div>
      <button> Iniciar </button>
    </div>
    
    <div class="boxRight" v-if="vistaActTarea">
      <br>Tareas a Terminar<br>
      <div class="grayBoxL">
        <label> Tareas Activas </label>
        <!--Mostrar Tareas con estado "2"-->
          
          <ul class="item-list">
            <li v-for="(t2, index) in tareas2" :key="index">
              {{t2.nombre_tarea}}
            </li>
          </ul>
          
      </div>
      <button> Terminar </button>
    </div>
    
 <!--------------------------------------------------->    
     <div class="statusFL" v-if="vistaStatus">
       <label> Emergencias Creadas </label>
       <div class="statusBox">
       <!--Mostrar Emergencias con estado "1"-->
       </div>
    </div>
    
     <div class="statusCL" v-if="vistaStatus">
       <label> Emergencias Iniciadas </label>
       <div class="statusBox">
       <!--Mostrar Emergencias con estado "2"-->
       </div>
    </div> 
    
    <div class="statusFR" v-if="vistaStatus">
       <label> Emergencias Finalizadas </label>
       <div class="statusBox">
       <!--Mostrar Emergencias con estado "3"-->
       </div>
    </div>
    
    <div class="statusCR" v-if="vistaStatus">
       <label> Emergencias Canceladas </label>
       <!--Mostrar Emergencias con estado "4"-->
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
      vistaStatus: false,
      newEmergencia:{ },
      newTarea:{ },
      emergencias3:[],
      emergencias2:[],
      emergencias1:[],
      tareas2:[],
      tareas1:[]
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
    },
     enviarE: async function() {
      try{
        var result = await this.$axios.post('/emergencia', this.newEmergencia);
        let emer = result.data;
        //mensaje de éxito
          //...
      } catch (error) {
        //mensaje de error
        console.log('error', error)
      }

    },

    enviarT: async function() {
      try{
        var result = await this.$axios.post('/tarea', this.newTarea);
        let tar = result.data;
        //mensaje de éxito
          //...
      } catch (error) {
        //mensaje de error
        console.log('error', error)
      }

    },
    getEmergencia3: async function(){
      try {
        let response = await this.$axios.get('/emergencia3');
        this.emergencias3 = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    },
    getEmergencia2: async function(){
      try {
        let response = await this.$axios.get('/emergencia2');
        this.emergencias2 = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    },
    getEmergencia1: async function(){
      try {
        let response = await this.$axios.get('/emergencia1');
        this.emergencias1 = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    },
    getTarea2: async function(){
      try {
        let response = await this.$axios.get('/tarea2');
        this.tareas2 = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    },
    getTarea1: async function(){
      try {
        let response = await this.$axios.get('/tarea1');
        this.tareas1 = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    }
  },
    
    //Funciónes que se ejecuta al cargar los componentes necesarios
  created:function(){
    this.getEmergencia3();
  },
  created:function(){
    this.getEmergencia2();
  },
  created:function(){
    this.getEmergencia1();
  },
  created:function(){
    this.getTarea2();
  },
  created:function(){
    this.getTarea1();
  }
  }

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