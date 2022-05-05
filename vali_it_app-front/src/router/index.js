import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from "@/views/LoginView";
import UserPageView from "@/views/UserPageView";
import SignUpView from "@/views/SignUpView";
import AdminPageView from "@/views/AdminPageView";
import WorkExperienceView from "@/views/WorkExperienceView";
import AddWorkExperience from "@/views/AddWorkExperience";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/user-page',
    name: 'user-page',
    component: UserPageView
  },
  {
    path: '/signup',
    name: 'sign-up',
    component: SignUpView
  },
  {
    path: '/admin',
    name: 'admin',
    component: AdminPageView
  },
  {
    path: '/work-experience',
    name: 'work-experience',
    component: WorkExperienceView
  },

  {
    path: '/work-experience/add',
    name: 'work-experience-add',
    component: AddWorkExperience
  },

]

const router = new VueRouter({
  routes
})

export default router
