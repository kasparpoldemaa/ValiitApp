<template>
  <div id="app">

    <nav>
      <router-link to="/">Esileht</router-link> |
      <router-link to="/login">Logi sisse </router-link> |
      <router-link v-if="getRoleId() == 2" to="/user-page">User Page (ajutine)</router-link> <span v-if="getRoleId() == 2" > | </span>
      <router-link to="/company-page">Company Page (ajutine)</router-link> |
      <router-link to="/admin">Admin (ajutine)</router-link>
      <button id="logout" type="button" class="btn btn-info" v-on:click="navigateToHomePage()">Logi välja</button>
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

    getRoleId: function () {
      return sessionStorage.getItem('roleId')
    },

    navigateToHomePage: function () {
      sessionStorage.clear()
      this.$router.push({name: 'home'})
    },

  },
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
  margin-top: -10px !important;
}

</style>
