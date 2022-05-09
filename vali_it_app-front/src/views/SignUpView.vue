<template>
  <div>

    <body>
    <div class="container">
      <div class="d-flex justify-content-center h-100">
        <div class="card">
          <div class="card-header">
            <h3>Loo uus kasutaja</h3>
          </div>

          <div class="card-body">

              <div class="form-group">
                <label for="exampleFormControlSelect1">Vali roll</label>
                <select class="form-control" id="exampleFormControlSelect1" v-model="request.roleId">
                  <option selected v-for="role in roles" :value="role.id">{{ role.name }}</option>
                </select>
              </div>

                <div class="input-group form-group">
                  <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/user.png">
                  </i></span>
                  </div>
                  <input type="text" class="form-control" placeholder="Eesnimi" v-model="request.firstName">
                </div>

                <div class="input-group form-group">
                  <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/user.png">
                  </i></span>
                  </div>
                  <input type="text" class="form-control" placeholder="Perekonnanimi" v-model="request.lastName">
                </div>

              <div v-if="request.roleId === 3">
                <div class="input-group form-group">
                  <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/business.png">
                  </i></span>
                  </div>
                  <input type="text" class="form-control" placeholder="Ettevõtte nimi" v-model="request.companyName">
                </div>
              </div>

              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/location.png">
                  </i></span>
                </div>
                <input type="text" class="form-control" placeholder="Aadress" v-model="request.address">
              </div>

              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user">
                  <img class="ui-menu-icons" alt="email" src="../assets/email.png">
                  </i></span>
                </div>
                <input type="text" class="form-control" placeholder="e-mail" v-model="request.userName">
              </div>

              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-key">
                    <img class="ui-menu-icons" alt="key" src="../assets/key.png">
                  </i></span>
                </div>
                <input type="password" class="form-control" placeholder="parool" v-model="request.password">
              </div>

              <div class="input-group form-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-key">
                    <img class="ui-menu-icons" alt="key" src="../assets/key.png">
                  </i></span>
                </div>
                <input type="password" class="form-control" placeholder="parool uuesti" v-model="passwordConfirm">
              </div>

              <div class="form-group">
                <input type="submit" value="Loo uus kasutaja" class="btn float-right login_btn"
                       v-on:click="addNewUser()">
              </div>

          </div>

          <div class="card-footer">
            Vali IT 2022
          </div>
        </div>
      </div>
    </div>
    </body>

  </div>
</template>

<script>
export default {
  name: "SignUpView",

  data: function () {
    return {
      request: {},
      roles: {},
      passwordConfirm: null,
      roleId: 0,
      userId: 0,
      contactId: 0 ,
      studentProfileId: 0,
      studentId: 0
    }

  },
  methods: {

    getAllRolesExceptAdmin: function () {
      this.$http.get("/role/not-admin")
          .then(response => {
            this.roles = response.data
            console.log(response.data)
          }).catch(error => {
        console.log(error)
      })
    },
    saveDataToSessionStorage: function () {
      sessionStorage.setItem('userId', this.userId)
      sessionStorage.setItem('roleId', this.roleId)
      sessionStorage.setItem('contactId', this.contactId)
      sessionStorage.setItem('studentProfileId', this.studentProfileId)
      sessionStorage.setItem('studentId', this.studentId)
    },
    navigateToUserPage: function () {
      if (this.roleId === 1){
        this.$router.push({name: 'admin'})
      }else if (this.roleId === 2){
        this.$router.push({name: 'user-page'})
      }else {
        this.$router.push({name: 'company-page'})
      }
    },

    addNewUser: function () {

      if (this.request.password === this.passwordConfirm) {
        this.$http.post("/register/new", this.request
        ).then(response => {
          this.userId = response.data.userId
          this.roleId = response.data.roleId
          this.contactId = response.data.contactId
          this.studentProfileId = response.data.studentProfileId
          this.studentId = response.data.studentId
          this.saveDataToSessionStorage()
          this.navigateToUserPage(response.data.userId)
        }).catch(error => {
          alert(error.response.data.detail)
          console.log(error.response.data)
        });
      } else {
        // todo viska teade, et parool ei klapi
        alert('parool ei klapi')
      }
    },


  },
  mounted() {
    this.getAllRolesExceptAdmin()
  }
}

</script>

<style scoped>
.ui-menu-icons {
  width: 18px;
  height: auto;
}

.login_btn {
  background-color: blue;
  color: white;
}

.login_btn:hover {
  color: white;
  background-color: deepskyblue;
}
</style>