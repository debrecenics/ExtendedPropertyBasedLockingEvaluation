package org.mondo.collaboration.eval.generator

class Templates {
	
	static def defaultTemplate() {
		'''
		package org.mondo.collaboration.queries
			
		import "http://wt/access-control"
		import "http://www.eclipse.org/emf/2002/Ecore"
		
		pattern containedBy(parent,child) {	
			Composite.submodules(parent,child);
		} or {
			Module.provides(parent,child);	
		}
		'''
	}
	
	static def maintananceTemplate(String i) {
		'''
		pattern userM«i»(ctrl: Control, sgn: Signal, f«IF i.isNullOrEmpty», c«ENDIF») {
			Control.cycle(ctrl, «IF i.isNullOrEmpty»c«ELSE»"«i»"«ENDIF»);
			Control.provides(ctrl,sgn);
			Signal.frequency(sgn,f);
		}
		'''
	}
	
	static def testingTemplate(String i) {
		'''
		pattern userT«i»(ctrl: Control, sgn: Signal, c, t) {
			Control.type(ctrl, t);
			«IF !i.isNullOrEmpty»Control.type(ctrl, "«i»");«ENDIF»
			Control.cycle(ctrl, c);
			Control.provides(ctrl,sgn);
		} or {
			Control.type(ctrl, t);
			«IF !i.isNullOrEmpty»Control.type(ctrl, "«i»");«ENDIF»
			Control.cycle(ctrl, c);
			Control.consumes(ctrl,sgn);
		}
		'''
	}
	
	static def replacingTemplate(String i) {
		'''
		pattern userR«i»(vendor, object, composite : Composite) {
			Composite.vendor(composite,vendor);
			«IF !i.isNullOrEmpty»Composite.vendor(composite,"«i»");«ENDIF»
			find containedBy+(composite,object);
		}
		
		pattern userR«i»ControlCycle(vendor, object, cycle, composite : Composite) {
			Composite.vendor(composite,vendor);
			«IF !i.isNullOrEmpty»Composite.vendor(composite,"«i»");«ENDIF»
			find containedBy+(composite,object);
			Control.cycle(object, cycle);
		}
		
		pattern userR«i»ControlType(vendor, object : Control, type, composite : Composite) {
			Composite.vendor(composite,vendor);
			«IF !i.isNullOrEmpty»Composite.vendor(composite,"«i»");«ENDIF»
			find containedBy+(composite,object);
			Control.type(object, type);
		}
		
		pattern userR«i»ControlProvide(vendor, object : Control, signal : Signal, composite : Composite) {
			Composite.vendor(composite,vendor);
			«IF !i.isNullOrEmpty»Composite.vendor(composite,"«i»");«ENDIF»
			find containedBy+(composite,object);
			Control.provides(object, signal);
		}
		
		pattern userR«i»ControlConsume(vendor, object, signal : Signal, composite : Composite) {
			Composite.vendor(composite,vendor);
			«IF !i.isNullOrEmpty»Composite.vendor(composite,"«i»");«ENDIF»
			find containedBy+(composite,object);
			Control.consumes(object, signal);
		}
		
		pattern userR«i»SignalFrequency(vendor, object : Signal, frequency, composite : Composite) {
			Composite.vendor(composite,vendor);
			«IF !i.isNullOrEmpty»Composite.vendor(composite,"«i»");«ENDIF»
			find containedBy+(composite,object);
			Signal.frequency(object, frequency);
		}		
		'''
	}
	
}