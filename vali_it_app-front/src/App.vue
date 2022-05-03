<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/login">Login</router-link> |
      <router-link to="/user-page">User Page (ajutine)</router-link> |
      <router-link to="/signup">SignUp (ajutine)</router-link> |
      <button type="button" class="btn btn-link btn-sm" v-on:click="navigateToHomePage()">Log out</button>
    </nav>
    <router-view/>
  </div>
</template>
<script>
export default {
  name: "SignUpView",

  data: function () {
    return {

    }

  },
  methods: {

    navigateToHomePage: function () {
      sessionStorage.clear()
      this.$router.push({name: 'home'})
    },

  },
}

</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
button {
  text-align: center;
  padding: 100px;

}

</style>
