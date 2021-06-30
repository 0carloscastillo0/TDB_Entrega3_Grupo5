import { wrapFunctional } from './utils'

export { default as NuxtLogo } from '../..\\components\\NuxtLogo.vue'
export { default as VistaInicial } from '../..\\components\\VistaInicial.vue'

export const LazyNuxtLogo = import('../..\\components\\NuxtLogo.vue' /* webpackChunkName: "components/nuxt-logo" */).then(c => wrapFunctional(c.default || c))
export const LazyVistaInicial = import('../..\\components\\VistaInicial.vue' /* webpackChunkName: "components/vista-inicial" */).then(c => wrapFunctional(c.default || c))
