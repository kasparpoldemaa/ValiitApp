<template>
  <div id="app">

    <nav>
      <router-link to="/">Esileht</router-link> |
      <router-link v-if="getRoleId() == null" to="/login">Logi sisse</router-link>
      <router-link v-if="getRoleId() == 2" to="/user-page">Minu Konto</router-link>
      <router-link v-if="getRoleId() == 3" to="/company-page">Minu Konto</router-link>
      <router-link v-if="getRoleId() == 1" to="/admin">Admin</router-link>
      <button v-if="getRoleId() != null" id="logout" type="button" class="btn btn-info btn-sm" v-on:click="navigateToHomePage()">Logi välja</button>
    </nav>
    <router-view/>
<!--<footer></footer>-->
  </div>

</template>
<script>
export default {
  name: "SignUpView",


  data: function () {
    return {
    roleId: sessionStorage.getItem('roleId')
    }

  },
  methods: {

    refreshPage: function () {
      window.location.reload();
    },

    getRoleId: function () {
      return sessionStorage.getItem('roleId')
    },

    navigateToHomePage: function () {
      sessionStorage.clear()

      if (1){
        this.$router.push({name: 'home'})
      }else{
        this.refreshPage()
      }
    },



  },

  mounted() {


  }
}

</script>
<style>
#app {
  font-family: 'Poppins', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

  /*z-index: 1000;*/
}


nav {
  padding: 30px;
  background-color: #4078A9;
}

/*footer {*/
/*  padding: 20px;*/
/*  background-color: #4078A9;*/
/*}*/

nav a {
  font-weight: bold;
  color: #C6DEF2;
}

nav a.router-link-exact-active {
  color: #C6DEF2;
}
button {
  text-align: center;
  padding: 100px;
}


/*.btn-default, .btn-default:hover, .btn-default:active, .btn-default:visited {*/
/*  background-color: #16A085 !important;*/
/*  color: white;*/
/*  */
/*}*/
#logout {
  float: right;
  margin-top: -5px !important;
  margin-left: -200px;

}

</style>
