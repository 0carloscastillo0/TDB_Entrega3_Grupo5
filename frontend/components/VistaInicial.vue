<!-- Use preprocessors via the lang attribute! e.g. <template lang="pug"> -->
<template>
  <div id="app">
    <h1>{{mensaje}}</h1>
    <button @click="emergencia">Crear Emergencia</button>
    <button @click="crearTarea">Crear Tarea</button>
    <button @click="verEmergencia">Ver Emergencias</button>
    <button @click="verTarea">Ver Tareas</button>
    <button @click="verVoluntarios">Voluntarios Inscritos</button>
    <button @click="listEmergencias">Listar emergencias</button>
<!-------------------------CREAR EMERGENCIA-------------------------->  
    
    <div class="box" v-if="vistaEmergencia">
      <p>Vista Emergencia</p>
      <form>
        <div class="cajaIzq">
          <label for="miInput">Nombre Emergencia</label><br>
          <input id="nombre" size="30" v-model="newEmergencia.nombre_emergencia" type="text">
        </div>
        <div class="cajaDer">
          <label for="miInput">Institucion</label><br>
          <select v-model="selected">
            <option v-for="institucion in instituciones" v-bind:value="institucion.id">
              {{ institucion.nombre}}
            </option>
          </select>
          
        </div>

        <div class="cajaAbaIzq">
          <label for="miInput">Descripcion Emergencia</label><br>
          <textarea id="descripcion" name="descripcion" v-model="newEmergencia.descripcion_emergencia" rows="7" cols="40"> 
          </textarea>
        </div>
        
      </form>
      <button @click="enviarE"> Crear </button> 
    </div> 
    
    
<!-----------------------CREAR TAREA---------------------------->    
    
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
     
    </div>
    
<!------------------------VER EMERGENCIAS--------------------------->    

    <div class="box" v-if="vistaActEmer">
      <h1> Emergencias </h1>
      <div class="grayBoxLE">
        
          <table class="table table-striped">
            <thead>
              <th>ID</th>
              <th>Nombre</th>
              <th>Descripcion</th>
            </thead>

            <tbody>
                <tr v-for="(item, index) in emergencias" :key="index">
                  <td>{{item.id_emergencia}}</td>
                  <td>{{item.nombre_emergencia}}</td>
                  <td>{{item.descripcion_emergencia}}</td>
                </tr>
            </tbody>
          </table>
         
      </div>
    </div>
    

  <!---------------------- VER TAREAS----------------------------->    
      
   <div class="box" v-if="vistaActTarea">
      <h1> Tareas </h1>
      <div class="grayBoxLE">
        
          <table class="table table-striped">
            <thead>
              <th>ID</th>
              <th>Nombre</th>
              <th>Descripcion</th>
              <th>N° voluntarios requeridos</th>
              <th>N° voluntarios inscritos</th>
            </thead>

            <tbody>
                <tr v-for="(item, index) in tareasAll" :key="index">
                  <td>{{item.id_tarea}}</td>
                  <td>{{item.nombre_tarea}}</td>
                  <td>{{item.descripcion_tarea}}</td>
                  <td>{{item.cant_vol_requeridos}}</td>
                  <td>{{item.cant_vol_inscritos}}</td>
                </tr>
            </tbody>
          </table>
         
      </div>
    </div>
    
  <!----------------------TAREAS CON MENOS VOLUNTARIOS----------------------------->    
      
    <div class="boxLeft" v-if="vistaVoluntarios">
      <h1>Emergencias </h1>
      <div class="grayBoxL">
        <select v-model="selected">
          <option v-for="emergencia in emergencias" v-bind:value="emergencia.id_emergencia">
            {{ emergencia.nombre_emergencia }}
          </option>
        </select>
      </div>
    </div>
        
    
    <div class="boxRight" v-if="vistaVoluntarios">
      <h1>Tareas</h1>
      <div class="grayBoxL">
        <table class="table table-striped">
          <thead>
            <th>Id</th>
            <th>Nombre</th>
            <th>Voluntarios inscritos</th>
          </thead>

          <tbody>
              <tr v-for="(item, index) in tareas" :key="index">
                <td>{{item.id_tarea}}</td>
                <td>{{item.nombre_tarea}}</td>
                <td>{{item.cant_vol_inscritos}}</td>
              </tr>

          </tbody>
        </table>
      </div>
    </div>
    
 <!------------------------EMERGENCIAS X REGION--------------------------->    
    
    <div class="box" v-if="vistaListEmergencias">
      <p style="color:black;background: #faff71;">Listar emergencias por región</p>
      <form>
        <div class="cajaTextoLE">
          <label for="miInput">Seleccione una región :</label><br>
        </div>
        
        <div class="cajaRegiones">
          <select v-model="selected2">
            <option v-for="region in regiones" v-bind:value="region.value">
              {{ region.text }}
            </option>
          </select>
        </div>
        <div class="boxListE">
          <table class="table table-striped">
            <thead>
              <th>Nombre</th>
              <th>Descripcion</th>
            </thead>

            <tbody>
                <tr v-for="(item, index) in emergencias2" :key="index">
                  <td>{{item.nombre_emergencia}}</td>
                  <td>{{item.descripcion_emergencia}}</td>
                </tr>

            </tbody>
          </table>
        </div>
      </form>
    </div>
  </div>
</template>




<!-----------------------SCRIPTS---------------------------->    
<script>
  export default {
  data() {
    return {
      mensaje:'ChileVoluntarios',
      vistaEmergencia: true,
      vistaTarea: false,
      vistaActEmer: false,
      vistaActTarea: false,
      vistaStatus: false,
      vistaListEmergencias: false,
      vistaVoluntarios: false,
      newEmergencia:{ },
      newTarea:{ },
      emergencias2:[],
      emergencias:[],
      selected: '0',
      instituciones:[],
      tareasAll:[{nombre_tarea: 'a'}],
      tareas:[],
      selected2: '0',
      selected3: '0',
      regiones:[
        {text:'Arica y Parinacota', value:'15'},
        {text:'Vaparaíso', value:'5'},
        {text:'Libertador Bernando O Higgins', value:'6'},
        {text:'Los Lagos', value:'10'},
        {text:'Atacama', value:'3'},
        {text:'Metropolitana de Santiago', value:'13'},
        {text:'La Araucania', value:'9'},
        {text:'Maule', value:'7'},
        {text:'Taracapá', value:'1'},
        {text:'Los rios', value:'14'},
        {text:'Bío-Bío', value:'8'},
        {text:'Aysén del Gral.Ibañez del Campo', value:'11'},
        {text:'Antofagasta', value:'2'},
        {text:'Coquimbo', value:'4'},
        {text:'Magallanes y Antártica Chilena', value:'12'}
      ]
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
      this.vistaListEmergencias= false;
      this.vistaVoluntarios= false;
    } ,
    emergencia(){
      this.vistaTarea=false;
      this.vistaEmergencia=true;
      this.vistaActEmer=false;
      this.vistaActTarea=false;
      this.vistaLog=false;
      this.vistaStatus=false;
      this.vistaListEmergencias= false;
      this.vistaVoluntarios= false;
    },
    verTarea(){
      this.vistaTarea=false;
      this.vistaEmergencia=false;
      this.vistaActEmer=false;
      this.vistaActTarea=true;
      this.vistaLog=false;
      this.vistaStatus=false;
      this.vistaListEmergencias= false;
      this.vistaVoluntarios= false;
    },
    verEmergencia(){
      this.vistaTarea=false;
      this.vistaEmergencia=false;
      this.vistaActEmer=true;
      this.vistaActTarea=false;
      this.vistaLog=false;
      this.vistaStatus=false;
      this.vistaListEmergencias= false;
      this.vistaVoluntarios= false;
    },
    listEmergencias(){
      this.vistaTarea=false;
      this.vistaEmergencia=false;
      this.vistaActEmer=false;
      this.vistaActTarea=false;
      this.vistaLog=false;
      this.vistaStatus=false;
      this.vistaListEmergencias= true;
      this.vistaVoluntarios= false;
    },
    verVoluntarios(){
      this.vistaTarea=false;
      this.vistaEmergencia=false;
      this.vistaActEmer=false;
      this.vistaActTarea=false;
      this.vistaLog=false;
      this.vistaStatus=false;
      this.vistaListEmergencias= false;
      this.vistaVoluntarios= true;
    },
    getData: async function(){
      try {
          let response = await this.$axios.get('/institucion');
          this.instituciones  = response.data;
          console.log(response)
      } catch (error) {
          console.log('error', error);
      }
    },
    getTareas: async function(){
      try {
          let response = await this.$axios.get('/tarea');
          this.tareasAll = response.data;
          console.log(response)
      } catch (error) {
          console.log('error', error);
      }
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
    getEmergencias: async function(){
      try {
        let response = await this.$axios.get('/emergencia');
        this.emergencias = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    },
    getTareasPorEmer: async function(){
      try {
        let response = await this.$axios.get('/tarea/emergencia/'+this.selected);
        this.tareas = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    }

  },
  watch:{
    selected: async function(){
      try {
        let response = await this.$axios.get('/tarea/emergencia/'+this.selected);
        this.tareas = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    },
    selected2: async function(){
      try {
        let response = await this.$axios.get('/emergencia/region/'+this.selected2);
        this.emergencias2 = response.data;
        console.log(response)
      } catch (error) {
        console.log('error', error);
      }
    }

  },

  //Funciónes que se ejecuta al cargar los componentes necesarios

  created:function(){
    this.getEmergencias();
    this.getData();
    this.getTareas();
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
  color: black;
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
    
    left: 8%;
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
  .cajaRegiones{
    position: absolute;
    width: 300px;
    height: 25px;
    left: 254px;
    top: 60px;
    background: #f0f2c5;
    color: black;
    border-radius: 33px;
  }
  .cajaTextoLE{
   position: absolute;
   width: 280px;
   height: 25px;
   left: 15px;
   top: 60px;
   background: #f0f2c5;
   color: black;
   border-radius: 33px;
  }
  .boxListE{
    position: absolute;
    width: 880px;
    height: 340px;
    left: 50px;
    top: 100px;
    color: black;
    background: #C4C4C4;
    border-radius: 33px;
 }
  
</style>