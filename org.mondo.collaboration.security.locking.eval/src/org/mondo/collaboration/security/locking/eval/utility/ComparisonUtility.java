package org.mondo.collaboration.security.locking.eval.utility;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;

public class ComparisonUtility {

	public static Comparison compare(Notifier local, Notifier remote, Notifier original) {
		IComparisonScope scope = new DefaultComparisonScope(local, remote, original);
		return EMFCompare.builder().build().compare(scope);
	}
	
	public static Comparison compare(Notifier local, Notifier remote) {
		IComparisonScope scope = new DefaultComparisonScope(local, null, remote);
		return EMFCompare.builder().build().compare(scope);
	}
}
